package com.google.android.gms.vision;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.material.internal.ViewUtils;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.ShapeTypes;

/* JADX INFO: loaded from: classes2.dex */
public class CameraSource {

    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_BACK = 0;

    @SuppressLint({"InlinedApi"})
    public static final int CAMERA_FACING_FRONT = 1;
    private Context zza;
    private final Object zzb;
    private Camera zzc;
    private int zzd;
    private int zze;
    private Size zzf;
    private float zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private String zzk;
    private SurfaceTexture zzl;
    private Thread zzm;
    private a zzn;
    private final IdentityHashMap<byte[], ByteBuffer> zzo;

    public static class Builder {
        private final Detector<?> zza;
        private CameraSource zzb;

        public Builder(@RecentlyNonNull Context context, @RecentlyNonNull Detector<?> detector) {
            CameraSource cameraSource = new CameraSource();
            this.zzb = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            }
            if (detector == null) {
                throw new IllegalArgumentException("No detector supplied.");
            }
            this.zza = detector;
            cameraSource.zza = context;
        }

        @RecentlyNonNull
        public CameraSource build() {
            CameraSource cameraSource = this.zzb;
            cameraSource.getClass();
            cameraSource.zzn = cameraSource.new a(this.zza);
            return this.zzb;
        }

        @RecentlyNonNull
        public Builder setAutoFocusEnabled(boolean z) {
            this.zzb.zzj = z;
            return this;
        }

        @RecentlyNonNull
        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                this.zzb.zzd = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(27);
            sb.append("Invalid camera: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        @RecentlyNonNull
        public Builder setFocusMode(@RecentlyNonNull String str) {
            if (str.equals("continuous-video") || str.equals("continuous-picture")) {
                this.zzb.zzk = str;
            } else {
                Log.w("CameraSource", String.format("FocusMode %s is not supported for now.", str));
                this.zzb.zzk = null;
            }
            return this;
        }

        @RecentlyNonNull
        public Builder setRequestedFps(float f) {
            if (f > 0.0f) {
                this.zzb.zzg = f;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid fps: ");
            sb.append(f);
            throw new IllegalArgumentException(sb.toString());
        }

        @RecentlyNonNull
        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i > 0 && i <= 1000000 && i2 > 0 && i2 <= 1000000) {
                this.zzb.zzh = i;
                this.zzb.zzi = i2;
                return this;
            }
            StringBuilder sb = new StringBuilder(45);
            sb.append("Invalid preview size: ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public interface PictureCallback {
        void onPictureTaken(@RecentlyNonNull byte[] bArr);
    }

    public interface ShutterCallback {
        void onShutter();
    }

    public class a implements Runnable {
        public Detector a;
        public long e;
        public ByteBuffer g;
        public long b = SystemClock.elapsedRealtime();
        public final Object c = new Object();
        public boolean d = true;
        public int f = 0;

        public a(Detector detector) {
            this.a = detector;
        }

        public final void a() {
            Detector detector = this.a;
            if (detector != null) {
                detector.release();
                this.a = null;
            }
        }

        public final void b(boolean z) {
            synchronized (this.c) {
                this.d = z;
                this.c.notifyAll();
            }
        }

        public final void c(byte[] bArr, Camera camera) {
            synchronized (this.c) {
                try {
                    ByteBuffer byteBuffer = this.g;
                    if (byteBuffer != null) {
                        camera.addCallbackBuffer(byteBuffer.array());
                        this.g = null;
                    }
                    if (!CameraSource.this.zzo.containsKey(bArr)) {
                        Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
                        return;
                    }
                    this.e = SystemClock.elapsedRealtime() - this.b;
                    this.f++;
                    this.g = (ByteBuffer) CameraSource.this.zzo.get(bArr);
                    this.c.notifyAll();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            boolean z;
            Frame frameBuild;
            ByteBuffer byteBuffer;
            while (true) {
                synchronized (this.c) {
                    while (true) {
                        z = this.d;
                        if (!z || this.g != null) {
                            break;
                        }
                        try {
                            this.c.wait();
                        } catch (InterruptedException e) {
                            Log.d("CameraSource", "Frame processing loop terminated.", e);
                            return;
                        }
                    }
                    if (!z) {
                        return;
                    }
                    frameBuild = new Frame.Builder().setImageData((ByteBuffer) Preconditions.checkNotNull(this.g), CameraSource.this.zzf.getWidth(), CameraSource.this.zzf.getHeight(), 17).setId(this.f).setTimestampMillis(this.e).setRotation(CameraSource.this.zze).build();
                    byteBuffer = this.g;
                    this.g = null;
                }
                try {
                    try {
                        ((Detector) Preconditions.checkNotNull(this.a)).receiveFrame(frameBuild);
                        ((Camera) Preconditions.checkNotNull(CameraSource.this.zzc)).addCallbackBuffer(((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).array());
                    } catch (Exception e2) {
                        Log.e("CameraSource", "Exception thrown from receiver.", e2);
                        ((Camera) Preconditions.checkNotNull(CameraSource.this.zzc)).addCallbackBuffer(((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).array());
                    }
                } catch (Throwable th) {
                    ((Camera) Preconditions.checkNotNull(CameraSource.this.zzc)).addCallbackBuffer(((ByteBuffer) Preconditions.checkNotNull(byteBuffer)).array());
                    throw th;
                }
            }
        }
    }

    public class b implements Camera.PreviewCallback {
        public b() {
        }

        @Override // android.hardware.Camera.PreviewCallback
        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzn.c(bArr, camera);
        }
    }

    public class c implements Camera.PictureCallback {
        public PictureCallback a;

        public c() {
        }

        @Override // android.hardware.Camera.PictureCallback
        public final void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.a;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzb) {
                try {
                    if (CameraSource.this.zzc != null) {
                        CameraSource.this.zzc.startPreview();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class d implements Camera.ShutterCallback {
        public ShutterCallback a;

        public d() {
        }

        @Override // android.hardware.Camera.ShutterCallback
        public final void onShutter() {
            ShutterCallback shutterCallback = this.a;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    public static class e {
        public Size a;
        public Size b;

        public e(Camera.Size size, Camera.Size size2) {
            this.a = new Size(size.width, size.height);
            if (size2 != null) {
                this.b = new Size(size2.width, size2.height);
            }
        }

        public final Size a() {
            return this.a;
        }

        public final Size b() {
            return this.b;
        }
    }

    private CameraSource() {
        this.zzb = new Object();
        this.zzd = 0;
        this.zzg = 30.0f;
        this.zzh = 1024;
        this.zzi = ViewUtils.EDGE_TO_EDGE_FLAGS;
        this.zzj = false;
        this.zzo = new IdentityHashMap<>();
    }

    @SuppressLint({"InlinedApi"})
    private final Camera zza() throws IOException {
        int i;
        int i2;
        int i3;
        int i4 = this.zzd;
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int i5 = 0;
        while (true) {
            if (i5 >= Camera.getNumberOfCameras()) {
                i5 = -1;
                break;
            }
            Camera.getCameraInfo(i5, cameraInfo);
            if (cameraInfo.facing == i4) {
                break;
            }
            i5++;
        }
        if (i5 == -1) {
            throw new IOException("Could not find requested camera.");
        }
        Camera cameraOpen = Camera.open(i5);
        int i6 = this.zzh;
        int i7 = this.zzi;
        Camera.Parameters parameters = cameraOpen.getParameters();
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : supportedPreviewSizes) {
            float f = size.width / size.height;
            for (Camera.Size size2 : supportedPictureSizes) {
                if (Math.abs(f - (size2.width / size2.height)) < 0.01f) {
                    arrayList.add(new e(size, size2));
                    break;
                }
            }
        }
        if (arrayList.size() == 0) {
            Log.w("CameraSource", "No preview sizes have a corresponding same-aspect-ratio picture size");
            Iterator<Camera.Size> it = supportedPreviewSizes.iterator();
            while (it.hasNext()) {
                arrayList.add(new e(it.next(), null));
            }
        }
        int size3 = arrayList.size();
        int i8 = Integer.MAX_VALUE;
        e eVar = null;
        int i9 = 0;
        int i10 = Integer.MAX_VALUE;
        while (i9 < size3) {
            Object obj = arrayList.get(i9);
            i9++;
            e eVar2 = (e) obj;
            Size sizeA = eVar2.a();
            int iAbs = Math.abs(sizeA.getWidth() - i6) + Math.abs(sizeA.getHeight() - i7);
            if (iAbs < i10) {
                eVar = eVar2;
                i10 = iAbs;
            }
        }
        e eVar3 = (e) Preconditions.checkNotNull(eVar);
        if (eVar3 == null) {
            throw new IOException("Could not find suitable preview size.");
        }
        Size sizeB = eVar3.b();
        this.zzf = eVar3.a();
        int i11 = (int) (this.zzg * 1000.0f);
        int[] iArr = null;
        for (int[] iArr2 : cameraOpen.getParameters().getSupportedPreviewFpsRange()) {
            int iAbs2 = Math.abs(i11 - iArr2[0]) + Math.abs(i11 - iArr2[1]);
            if (iAbs2 < i8) {
                iArr = iArr2;
                i8 = iAbs2;
            }
        }
        int[] iArr3 = (int[]) Preconditions.checkNotNull(iArr);
        if (iArr3 == null) {
            throw new IOException("Could not find suitable preview frames per second range.");
        }
        Camera.Parameters parameters2 = cameraOpen.getParameters();
        if (sizeB != null) {
            parameters2.setPictureSize(sizeB.getWidth(), sizeB.getHeight());
        }
        parameters2.setPreviewSize(this.zzf.getWidth(), this.zzf.getHeight());
        parameters2.setPreviewFpsRange(iArr3[0], iArr3[1]);
        parameters2.setPreviewFormat(17);
        int rotation = ((WindowManager) Preconditions.checkNotNull((WindowManager) this.zza.getSystemService("window"))).getDefaultDisplay().getRotation();
        if (rotation == 0) {
            i = 0;
        } else if (rotation == 1) {
            i = 90;
        } else if (rotation == 2) {
            i = ShapeTypes.MATH_EQUAL;
        } else if (rotation != 3) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Bad rotation value: ");
            sb.append(rotation);
            Log.e("CameraSource", sb.toString());
            i = 0;
        } else {
            i = TIFFConstants.TIFFTAG_IMAGEDESCRIPTION;
        }
        Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
        Camera.getCameraInfo(i5, cameraInfo2);
        if (cameraInfo2.facing == 1) {
            i2 = (cameraInfo2.orientation + i) % 360;
            i3 = (360 - i2) % 360;
        } else {
            i2 = ((cameraInfo2.orientation - i) + 360) % 360;
            i3 = i2;
        }
        this.zze = i2 / 90;
        cameraOpen.setDisplayOrientation(i3);
        parameters2.setRotation(i2);
        if (this.zzk != null) {
            if (parameters2.getSupportedFocusModes().contains(this.zzk)) {
                parameters2.setFocusMode((String) Preconditions.checkNotNull(this.zzk));
            } else {
                Log.w("CameraSource", String.format("FocusMode %s is not supported on this device.", this.zzk));
                this.zzk = null;
            }
        }
        if (this.zzk == null && this.zzj) {
            if (parameters2.getSupportedFocusModes().contains("continuous-video")) {
                parameters2.setFocusMode("continuous-video");
                this.zzk = "continuous-video";
            } else {
                Log.i("CameraSource", "Camera auto focus is not supported on this device.");
            }
        }
        cameraOpen.setParameters(parameters2);
        cameraOpen.setPreviewCallbackWithBuffer(new b());
        cameraOpen.addCallbackBuffer(zza(this.zzf));
        cameraOpen.addCallbackBuffer(zza(this.zzf));
        cameraOpen.addCallbackBuffer(zza(this.zzf));
        cameraOpen.addCallbackBuffer(zza(this.zzf));
        return cameraOpen;
    }

    public int getCameraFacing() {
        return this.zzd;
    }

    @RecentlyNonNull
    public Size getPreviewSize() {
        return this.zzf;
    }

    public void release() {
        synchronized (this.zzb) {
            stop();
            this.zzn.a();
        }
    }

    @RecentlyNonNull
    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start() {
        synchronized (this.zzb) {
            try {
                if (this.zzc != null) {
                    return this;
                }
                this.zzc = zza();
                SurfaceTexture surfaceTexture = new SurfaceTexture(100);
                this.zzl = surfaceTexture;
                this.zzc.setPreviewTexture(surfaceTexture);
                this.zzc.startPreview();
                Thread thread = new Thread(this.zzn);
                this.zzm = thread;
                thread.setName("gms.vision.CameraSource");
                this.zzn.b(true);
                Thread thread2 = this.zzm;
                if (thread2 != null) {
                    thread2.start();
                }
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0021 A[Catch: all -> 0x0012, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x000e, B:12:0x001b, B:13:0x001d, B:15:0x0021, B:16:0x0029, B:20:0x0057, B:19:0x0037, B:21:0x0064, B:22:0x0069, B:11:0x0014), top: B:28:0x0003, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0064 A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:4:0x0003, B:7:0x000e, B:12:0x001b, B:13:0x001d, B:15:0x0021, B:16:0x0029, B:20:0x0057, B:19:0x0037, B:21:0x0064, B:22:0x0069, B:11:0x0014), top: B:28:0x0003, inners: #0, #2 }] */
    public void stop() {
        Camera camera;
        synchronized (this.zzb) {
            this.zzn.b(false);
            Thread thread = this.zzm;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzm = null;
                camera = this.zzc;
                if (camera != null) {
                    camera.stopPreview();
                    this.zzc.setPreviewCallbackWithBuffer(null);
                    try {
                        this.zzc.setPreviewTexture(null);
                        this.zzl = null;
                        this.zzc.setPreviewDisplay(null);
                    } catch (Exception e2) {
                        String strValueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
                        sb.append("Failed to clear camera preview: ");
                        sb.append(strValueOf);
                        Log.e("CameraSource", sb.toString());
                    }
                    ((Camera) Preconditions.checkNotNull(this.zzc)).release();
                    this.zzc = null;
                    this.zzo.clear();
                } else {
                    this.zzo.clear();
                }
            } else {
                camera = this.zzc;
                if (camera != null) {
                    camera.stopPreview();
                    this.zzc.setPreviewCallbackWithBuffer(null);
                    this.zzc.setPreviewTexture(null);
                    this.zzl = null;
                    this.zzc.setPreviewDisplay(null);
                    ((Camera) Preconditions.checkNotNull(this.zzc)).release();
                    this.zzc = null;
                    this.zzo.clear();
                } else {
                    this.zzo.clear();
                }
            }
            throw th;
        }
    }

    public void takePicture(ShutterCallback shutterCallback, PictureCallback pictureCallback) {
        synchronized (this.zzb) {
            try {
                if (this.zzc != null) {
                    d dVar = new d();
                    dVar.a = shutterCallback;
                    c cVar = new c();
                    cVar.a = pictureCallback;
                    this.zzc.takePicture(dVar, null, null, cVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @RecentlyNonNull
    @RequiresPermission("android.permission.CAMERA")
    public CameraSource start(@RecentlyNonNull SurfaceHolder surfaceHolder) {
        synchronized (this.zzb) {
            try {
                if (this.zzc != null) {
                    return this;
                }
                Camera cameraZza = zza();
                this.zzc = cameraZza;
                cameraZza.setPreviewDisplay(surfaceHolder);
                this.zzc.startPreview();
                this.zzm = new Thread(this.zzn);
                this.zzn.b(true);
                Thread thread = this.zzm;
                if (thread != null) {
                    thread.start();
                }
                return this;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @SuppressLint({"InlinedApi"})
    private final byte[] zza(Size size) {
        byte[] bArr = new byte[((int) Math.ceil(((((long) size.getHeight()) * ((long) size.getWidth())) * ((long) ImageFormat.getBitsPerPixel(17))) / 8.0d)) + 1];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        if (byteBufferWrap.hasArray() && byteBufferWrap.array() == bArr) {
            this.zzo.put(bArr, byteBufferWrap);
            return bArr;
        }
        throw new IllegalStateException("Failed to create valid buffer for camera source.");
    }
}
