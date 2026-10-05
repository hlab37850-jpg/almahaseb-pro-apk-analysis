package com.google.android.gms.internal.vision;

/* JADX INFO: loaded from: classes2.dex */
public final class zzfi {

    public static final class zzm extends zzjb<zzm, zza> implements zzkm {
        private static final zzm zzf;
        private static volatile zzkx<zzm> zzg;
        private int zzc;
        private int zzd;
        private int zze;

        public static final class zza extends zzjb.zzb<zzm, zza> implements zzkm {
            private zza() {
                super(zzm.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzm) this.zza).zza(i);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzm) this.zza).zzc(i);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }
        }

        static {
            zzm zzmVar = new zzm();
            zzf = zzmVar;
            zzjb.zza((Class<zzm>) zzm.class, zzmVar);
        }

        private zzm() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        public static zza zza() {
            return zzf.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzm>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzm> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzm.class) {
                            try {
                                zzkx<zzm> zzkxVar2 = zzg;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzf);
                                    zzg = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzf extends zzjb<zzf, zzb> implements zzkm {
        private static final zzf zzl;
        private static volatile zzkx<zzf> zzm;
        private int zzc;
        private int zzg;
        private long zzi;
        private long zzj;
        private String zzd = "";
        private String zze = "";
        private zzjl<String> zzf = zzjb.zzo();
        private String zzh = "";
        private zzjl<zzn> zzk = zzjb.zzo();

        public enum zza implements zzje {
            RESULT_UNKNOWN(0),
            RESULT_SUCCESS(1),
            RESULT_FAIL(2),
            RESULT_SKIPPED(3);

            private static final zzjh<zza> zze = new i();
            private final int zzf;

            zza(int i) {
                this.zzf = i;
            }

            public static zzjg zzb() {
                return h.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return RESULT_UNKNOWN;
                }
                if (i == 1) {
                    return RESULT_SUCCESS;
                }
                if (i == 2) {
                    return RESULT_FAIL;
                }
                if (i != 3) {
                    return null;
                }
                return RESULT_SKIPPED;
            }
        }

        public static final class zzb extends zzjb.zzb<zzf, zzb> implements zzkm {
            private zzb() {
                super(zzf.zzl);
            }

            public final zzb zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza(str);
                return this;
            }

            public final zzb zzb(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zzb(j);
                return this;
            }

            public /* synthetic */ zzb(d dVar) {
                this();
            }

            public final zzb zza(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza(j);
                return this;
            }

            public final zzb zza(Iterable<? extends zzn> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zzf zzfVar = new zzf();
            zzl = zzfVar;
            zzjb.zza((Class<zzf>) zzf.class, zzfVar);
        }

        private zzf() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 32;
            this.zzj = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 16;
            this.zzi = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzn> iterable) {
            zzjl<zzn> zzjlVar = this.zzk;
            if (!zzjlVar.zza()) {
                this.zzk = zzjb.zza(zzjlVar);
            }
            zzhf.zza(iterable, this.zzk);
        }

        public static zzb zza() {
            return zzl.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzf>] */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zzb(dVar);
                case 3:
                    return zzjb.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001a\u0004ဌ\u0002\u0005ဈ\u0003\u0006ဂ\u0004\u0007ဂ\u0005\b\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zza.zzb(), "zzh", "zzi", "zzj", "zzk", zzn.class});
                case 4:
                    return zzl;
                case 5:
                    zzkx<zzf> zzkxVar = zzm;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzf.class) {
                            try {
                                zzkx<zzf> zzkxVar2 = zzm;
                                r3 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzl);
                                    zzm = zzaVar;
                                    r3 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r3;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzg extends zzjb<zzg, zza> implements zzkm {
        private static final zzg zzj;
        private static volatile zzkx<zzg> zzk;
        private int zzc;
        private int zzd;
        private int zze;
        private int zzf;
        private boolean zzg;
        private boolean zzh;
        private float zzi;

        public static final class zza extends zzjb.zzb<zzg, zza> implements zzkm {
            private zza() {
                super(zzg.zzj);
            }

            public final zza zza(zzd zzdVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzdVar);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }

            public final zza zza(zzc zzcVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzcVar);
                return this;
            }

            public final zza zza(zzb zzbVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzbVar);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final zza zza(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(f);
                return this;
            }
        }

        public enum zzb implements zzje {
            CLASSIFICATION_UNKNOWN(0),
            CLASSIFICATION_NONE(1),
            CLASSIFICATION_ALL(2);

            private static final zzjh<zzb> zzd = new j();
            private final int zze;

            zzb(int i) {
                this.zze = i;
            }

            public static zzjg zzb() {
                return k.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zze + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zze;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return CLASSIFICATION_UNKNOWN;
                }
                if (i == 1) {
                    return CLASSIFICATION_NONE;
                }
                if (i != 2) {
                    return null;
                }
                return CLASSIFICATION_ALL;
            }
        }

        public enum zzc implements zzje {
            LANDMARK_UNKNOWN(0),
            LANDMARK_NONE(1),
            LANDMARK_ALL(2),
            LANDMARK_CONTOUR(3);

            private static final zzjh<zzc> zze = new m();
            private final int zzf;

            zzc(int i) {
                this.zzf = i;
            }

            public static zzjg zzb() {
                return l.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzc.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzc zza(int i) {
                if (i == 0) {
                    return LANDMARK_UNKNOWN;
                }
                if (i == 1) {
                    return LANDMARK_NONE;
                }
                if (i == 2) {
                    return LANDMARK_ALL;
                }
                if (i != 3) {
                    return null;
                }
                return LANDMARK_CONTOUR;
            }
        }

        public enum zzd implements zzje {
            MODE_UNKNOWN(0),
            MODE_ACCURATE(1),
            MODE_FAST(2),
            MODE_SELFIE(3);

            private static final zzjh<zzd> zze = new n();
            private final int zzf;

            zzd(int i) {
                this.zzf = i;
            }

            public static zzjg zzb() {
                return o.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzd zza(int i) {
                if (i == 0) {
                    return MODE_UNKNOWN;
                }
                if (i == 1) {
                    return MODE_ACCURATE;
                }
                if (i == 2) {
                    return MODE_FAST;
                }
                if (i != 3) {
                    return null;
                }
                return MODE_SELFIE;
            }
        }

        static {
            zzg zzgVar = new zzg();
            zzj = zzgVar;
            zzjb.zza((Class<zzg>) zzg.class, zzgVar);
        }

        private zzg() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzd zzdVar) {
            this.zzd = zzdVar.zza();
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 16;
            this.zzh = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzc zzcVar) {
            this.zze = zzcVar.zza();
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzb zzbVar) {
            this.zzf = zzbVar.zza();
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(float f) {
            this.zzc |= 32;
            this.zzi = f;
        }

        public static zza zza() {
            return zzj.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v20 */
        /* JADX WARN: Type inference failed for: r5v21, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzg>] */
        /* JADX WARN: Type inference failed for: r5v24 */
        /* JADX WARN: Type inference failed for: r5v25 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r5;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", zzd.zzb(), "zze", zzc.zzb(), "zzf", zzb.zzb(), "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zzg> zzkxVar = zzk;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzg.class) {
                            try {
                                zzkx<zzg> zzkxVar2 = zzk;
                                r5 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzj);
                                    zzk = zzaVar;
                                    r5 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r5;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzh extends zzjb<zzh, zza> implements zzkm {
        private static final zzh zzj;
        private static volatile zzkx<zzh> zzk;
        private int zzc;
        private float zzd;
        private float zze;
        private float zzf;
        private float zzg;
        private float zzh;
        private float zzi;

        public static final class zza extends zzjb.zzb<zzh, zza> implements zzkm {
            private zza() {
                super(zzh.zzj);
            }

            public final zza zza(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza(f);
                return this;
            }

            public final zza zzb(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzb(f);
                return this;
            }

            public final zza zzc(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzc(f);
                return this;
            }

            public final zza zzd(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzd(f);
                return this;
            }

            public final zza zze(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zze(f);
                return this;
            }

            public final zza zzf(float f) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzh) this.zza).zzf(f);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }
        }

        static {
            zzh zzhVar = new zzh();
            zzj = zzhVar;
            zzjb.zza((Class<zzh>) zzh.class, zzhVar);
        }

        private zzh() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(float f) {
            this.zzc |= 1;
            this.zzd = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(float f) {
            this.zzc |= 2;
            this.zze = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(float f) {
            this.zzc |= 4;
            this.zzf = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(float f) {
            this.zzc |= 8;
            this.zzg = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zze(float f) {
            this.zzc |= 16;
            this.zzh = f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzf(float f) {
            this.zzc |= 32;
            this.zzi = f;
        }

        public static zza zza() {
            return zzj.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzh>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002\u0004ခ\u0003\u0005ခ\u0004\u0006ခ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zzh> zzkxVar = zzk;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzh.class) {
                            try {
                                zzkx<zzh> zzkxVar2 = zzk;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzj);
                                    zzk = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzj extends zzjb<zzj, zzb> implements zzkm {
        private static final zzj zzi;
        private static volatile zzkx<zzj> zzj;
        private int zzc;
        private int zzd;
        private long zze;
        private long zzf;
        private long zzg;
        private long zzh;

        public enum zza implements zzje {
            FORMAT_UNKNOWN(0),
            FORMAT_LUMINANCE(1),
            FORMAT_RGB8(2),
            FORMAT_MONOCHROME(3);

            private static final zzjh<zza> zze = new q();
            private final int zzf;

            zza(int i) {
                this.zzf = i;
            }

            public static zzjg zzb() {
                return p.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zza.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i == 1) {
                    return FORMAT_LUMINANCE;
                }
                if (i == 2) {
                    return FORMAT_RGB8;
                }
                if (i != 3) {
                    return null;
                }
                return FORMAT_MONOCHROME;
            }
        }

        public static final class zzb extends zzjb.zzb<zzj, zzb> implements zzkm {
            private zzb() {
                super(zzj.zzi);
            }

            public final zzb zza(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(j);
                return this;
            }

            public final zzb zzb(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(j);
                return this;
            }

            public final zzb zzc(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzc(j);
                return this;
            }

            public final zzb zzd(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzd(j);
                return this;
            }

            public /* synthetic */ zzb(d dVar) {
                this();
            }
        }

        static {
            zzj zzjVar = new zzj();
            zzi = zzjVar;
            zzjb.zza((Class<zzj>) zzj.class, zzjVar);
        }

        private zzj() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzh = j;
        }

        public static zzb zza() {
            return zzi.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzj>] */
        /* JADX WARN: Type inference failed for: r3v21 */
        /* JADX WARN: Type inference failed for: r3v22 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zzb(dVar);
                case 3:
                    return zzjb.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0004\u0005ဂ\u0003", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzh", "zzg"});
                case 4:
                    return zzi;
                case 5:
                    zzkx<zzj> zzkxVar = zzj;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzj.class) {
                            try {
                                zzkx<zzj> zzkxVar2 = zzj;
                                r3 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzi);
                                    zzj = zzaVar;
                                    r3 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r3;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zza extends zzjb<zza, C0182zza> implements zzkm {
        private static final zza zzf;
        private static volatile zzkx<zza> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        /* JADX INFO: renamed from: com.google.android.gms.internal.vision.zzfi$zza$zza, reason: collision with other inner class name */
        public static final class C0182zza extends zzjb.zzb<zza, C0182zza> implements zzkm {
            private C0182zza() {
                super(zza.zzf);
            }

            public final C0182zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C0182zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(str);
                return this;
            }

            public /* synthetic */ C0182zza(d dVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzf = zzaVar;
            zzjb.zza((Class<zza>) zza.class, zzaVar);
        }

        private zza() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public static C0182zza zza() {
            return zzf.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zza>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0182zza(dVar);
                case 3:
                    return zzjb.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zza> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zza.class) {
                            try {
                                zzkx<zza> zzkxVar2 = zzg;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzf);
                                    zzg = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzi extends zzjb<zzi, zza> implements zzkm {
        private static final zzi zzg;
        private static volatile zzkx<zzi> zzh;
        private int zzc;
        private zzj zzd;
        private zzl zze;
        private zzjl<zzf> zzf = zzjb.zzo();

        public static final class zza extends zzjb.zzb<zzi, zza> implements zzkm {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(zzj zzjVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(zzjVar);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }

            public final zza zza(zzf.zzb zzbVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza((zzf) ((zzjb) zzbVar.zzf()));
                return this;
            }

            public final zza zza(Iterable<? extends zzf> iterable) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(iterable);
                return this;
            }
        }

        static {
            zzi zziVar = new zzi();
            zzg = zziVar;
            zzjb.zza((Class<zzi>) zzi.class, zziVar);
        }

        private zzi() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzj zzjVar) {
            zzjVar.getClass();
            this.zzd = zzjVar;
            this.zzc |= 1;
        }

        private final void zzc() {
            zzjl<zzf> zzjlVar = this.zzf;
            if (zzjlVar.zza()) {
                return;
            }
            this.zzf = zzjb.zza(zzjlVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzf zzfVar) {
            zzfVar.getClass();
            zzc();
            this.zzf.add(zzfVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(Iterable<? extends zzf> iterable) {
            zzc();
            zzhf.zza(iterable, this.zzf);
        }

        public static zza zza() {
            return zzg.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzi>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", zzf.class});
                case 4:
                    return zzg;
                case 5:
                    zzkx<zzi> zzkxVar = zzh;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzi.class) {
                            try {
                                zzkx<zzi> zzkxVar2 = zzh;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzg);
                                    zzh = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzk extends zzjb<zzk, zza> implements zzkm {
        private static final zzk zzj;
        private static volatile zzkx<zzk> zzk;
        private int zzc;
        private long zze;
        private zza zzf;
        private zzg zzh;
        private zzb zzi;
        private String zzd = "";
        private String zzg = "";

        public static final class zza extends zzjb.zzb<zzk, zza> implements zzkm {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zza(zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(zzaVar);
                return this;
            }

            public final zza zza(zzg.zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza((zzg) ((zzjb) zzaVar.zzf()));
                return this;
            }
        }

        static {
            zzk zzkVar = new zzk();
            zzj = zzkVar;
            zzjb.zza((Class<zzk>) zzk.class, zzkVar);
        }

        private zzk() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zza zzaVar) {
            zzaVar.getClass();
            this.zzf = zzaVar;
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzg zzgVar) {
            zzgVar.getClass();
            this.zzh = zzgVar;
            this.zzc |= 16;
        }

        public static zza zza() {
            return zzj.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzk>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzj, "\u0001\u0006\u0000\u0001\u0001\u0011\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဉ\u0002\u0006ဈ\u0003\u0010ဉ\u0004\u0011ဉ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzkx<zzk> zzkxVar = zzk;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzk.class) {
                            try {
                                zzkx<zzk> zzkxVar2 = zzk;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzj);
                                    zzk = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzn extends zzjb<zzn, zza> implements zzkm {
        private static final zzn zzh;
        private static volatile zzkx<zzn> zzi;
        private int zzc;
        private zzd zzd;
        private int zze;
        private zzh zzf;
        private zzc zzg;

        public static final class zza extends zzjb.zzb<zzn, zza> implements zzkm {
            private zza() {
                super(zzn.zzh);
            }

            public final zza zza(zzd zzdVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(zzdVar);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }

            public final zza zza(zzd.zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza((zzd) ((zzjb) zzaVar.zzf()));
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(i);
                return this;
            }

            public final zza zza(zzh zzhVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzn) this.zza).zza(zzhVar);
                return this;
            }
        }

        static {
            zzn zznVar = new zzn();
            zzh = zznVar;
            zzjb.zza((Class<zzn>) zzn.class, zznVar);
        }

        private zzn() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzd zzdVar) {
            zzdVar.getClass();
            this.zzd = zzdVar;
            this.zzc |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 2;
            this.zze = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzh zzhVar) {
            zzhVar.getClass();
            this.zzf = zzhVar;
            this.zzc |= 4;
        }

        public static zza zza() {
            return zzh.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzn>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzh, "\u0001\u0004\u0000\u0001\u0001\u0011\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002င\u0001\u0010ဉ\u0002\u0011ဉ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzkx<zzn> zzkxVar = zzi;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzn.class) {
                            try {
                                zzkx<zzn> zzkxVar2 = zzi;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzh);
                                    zzi = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzo extends zzjb<zzo, zza> implements zzkm {
        private static final zzo zzi;
        private static volatile zzkx<zzo> zzj;
        private int zzc;
        private zze zzd;
        private zzk zze;
        private zzi zzf;
        private int zzg;
        private boolean zzh;

        public static final class zza extends zzjb.zzb<zzo, zza> implements zzkm {
            private zza() {
                super(zzo.zzi);
            }

            public final zza zza(zzk.zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzo) this.zza).zza((zzk) ((zzjb) zzaVar.zzf()));
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }

            public final zza zza(zzi zziVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzo) this.zza).zza(zziVar);
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzo) this.zza).zza(true);
                return this;
            }
        }

        static {
            zzo zzoVar = new zzo();
            zzi = zzoVar;
            zzjb.zza((Class<zzo>) zzo.class, zzoVar);
        }

        private zzo() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzk zzkVar) {
            zzkVar.getClass();
            this.zze = zzkVar;
            this.zzc |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzi zziVar) {
            zziVar.getClass();
            this.zzf = zziVar;
            this.zzc |= 4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 16;
            this.zzh = true;
        }

        public static zza zza() {
            return zzi.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzo>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004င\u0003\u0005ဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzkx<zzo> zzkxVar = zzj;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzo.class) {
                            try {
                                zzkx<zzo> zzkxVar2 = zzj;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzi);
                                    zzj = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzd extends zzjb<zzd, zza> implements zzkm {
        private static final zzd zzd;
        private static volatile zzkx<zzd> zze;
        private zzjl<zzm> zzc = zzjb.zzo();

        public static final class zza extends zzjb.zzb<zzd, zza> implements zzkm {
            private zza() {
                super(zzd.zzd);
            }

            public final zza zza(zzm zzmVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(zzmVar);
                return this;
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }

            public final zza zza(zzm.zza zzaVar) {
                if (this.zzb) {
                    zzb();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza((zzm) ((zzjb) zzaVar.zzf()));
                return this;
            }
        }

        static {
            zzd zzdVar = new zzd();
            zzd = zzdVar;
            zzjb.zza((Class<zzd>) zzd.class, zzdVar);
        }

        private zzd() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void zza(zzm zzmVar) {
            zzmVar.getClass();
            zzjl<zzm> zzjlVar = this.zzc;
            if (!zzjlVar.zza()) {
                this.zzc = zzjb.zza(zzjlVar);
            }
            this.zzc.add(zzmVar);
        }

        public static zza zza() {
            return zzd.zzj();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzd>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzm.class});
                case 4:
                    return zzd;
                case 5:
                    zzkx<zzd> zzkxVar = zze;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzd.class) {
                            try {
                                zzkx<zzd> zzkxVar2 = zze;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzd);
                                    zze = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzjb<zzb, zza> implements zzkm {
        private static final zzji<Integer, zzgz> zzd = new e();
        private static final zzb zze;
        private static volatile zzkx<zzb> zzf;
        private zzjj zzc = zzjb.zzn();

        public static final class zza extends zzjb.zzb<zzb, zza> implements zzkm {
            private zza() {
                super(zzb.zze);
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.vision.e, com.google.android.gms.internal.vision.zzji<java.lang.Integer, com.google.android.gms.internal.vision.zzgz>] */
        static {
            zzb zzbVar = new zzb();
            zze = zzbVar;
            zzjb.zza((Class<zzb>) zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzb>] */
        /* JADX WARN: Type inference failed for: r3v17 */
        /* JADX WARN: Type inference failed for: r3v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001e", new Object[]{"zzc", zzgz.zzb()});
                case 4:
                    return zze;
                case 5:
                    zzkx<zzb> zzkxVar = zzf;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzb.class) {
                            try {
                                zzkx<zzb> zzkxVar2 = zzf;
                                r3 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zze);
                                    zzf = zzaVar;
                                    r3 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r3;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zze extends zzjb<zze, zza> implements zzkm {
        private static final zze zzl;
        private static volatile zzkx<zze> zzm;
        private int zzc;
        private boolean zze;
        private int zzf;
        private long zzg;
        private long zzh;
        private long zzi;
        private boolean zzk;
        private String zzd = "";
        private String zzj = "";

        public static final class zza extends zzjb.zzb<zze, zza> implements zzkm {
            private zza() {
                super(zze.zzl);
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }
        }

        public enum zzb implements zzje {
            REASON_UNKNOWN(0),
            REASON_MISSING(1),
            REASON_UPGRADE(2),
            REASON_INVALID(3);

            private static final zzjh<zzb> zze = new f();
            private final int zzf;

            zzb(int i) {
                this.zzf = i;
            }

            public static zzjg zzb() {
                return g.a;
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "<" + zzb.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzf + " name=" + name() + '>';
            }

            @Override // com.google.android.gms.internal.vision.zzje
            public final int zza() {
                return this.zzf;
            }

            public static zzb zza(int i) {
                if (i == 0) {
                    return REASON_UNKNOWN;
                }
                if (i == 1) {
                    return REASON_MISSING;
                }
                if (i == 2) {
                    return REASON_UPGRADE;
                }
                if (i != 3) {
                    return null;
                }
                return REASON_INVALID;
            }
        }

        static {
            zze zzeVar = new zze();
            zzl = zzeVar;
            zzjb.zza((Class<zze>) zze.class, zzeVar);
        }

        private zze() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zze>] */
        /* JADX WARN: Type inference failed for: r3v22 */
        /* JADX WARN: Type inference failed for: r3v23 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r3;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဈ\u0006\bဇ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", zzb.zzb(), "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzkx<zze> zzkxVar = zzm;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zze.class) {
                            try {
                                zzkx<zze> zzkxVar2 = zzm;
                                r3 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzl);
                                    zzm = zzaVar;
                                    r3 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r3;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzl extends zzjb<zzl, zza> implements zzkm {
        private static final zzl zzf;
        private static volatile zzkx<zzl> zzg;
        private int zzc;
        private long zzd;
        private long zze;

        public static final class zza extends zzjb.zzb<zzl, zza> implements zzkm {
            private zza() {
                super(zzl.zzf);
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }
        }

        static {
            zzl zzlVar = new zzl();
            zzf = zzlVar;
            zzjb.zza((Class<zzl>) zzl.class, zzlVar);
        }

        private zzl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzl>] */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v18 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r2;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzkx<zzl> zzkxVar = zzg;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzl.class) {
                            try {
                                zzkx<zzl> zzkxVar2 = zzg;
                                r2 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzf);
                                    zzg = zzaVar;
                                    r2 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r2;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzc extends zzjb<zzc, zza> implements zzkm {
        private static final zzc zzg;
        private static volatile zzkx<zzc> zzh;
        private int zzc;
        private int zzd;
        private int zze;
        private String zzf = "";

        public static final class zza extends zzjb.zzb<zzc, zza> implements zzkm {
            private zza() {
                super(zzc.zzg);
            }

            public /* synthetic */ zza(d dVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzg = zzcVar;
            zzjb.zza((Class<zzc>) zzc.class, zzcVar);
        }

        private zzc() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v16 */
        /* JADX WARN: Type inference failed for: r4v17, types: [com.google.android.gms.internal.vision.zzjb$zza, com.google.android.gms.internal.vision.zzkx<com.google.android.gms.internal.vision.zzfi$zzc>] */
        /* JADX WARN: Type inference failed for: r4v20 */
        /* JADX WARN: Type inference failed for: r4v21 */
        @Override // com.google.android.gms.internal.vision.zzjb
        public final Object zza(int i, Object obj, Object obj2) {
            ?? r4;
            d dVar = null;
            switch (d.a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(dVar);
                case 3:
                    return zzjb.zza(zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဈ\u0002", new Object[]{"zzc", "zzd", zzgz.zzb(), "zze", zzha.zzb(), "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzkx<zzc> zzkxVar = zzh;
                    Object obj3 = zzkxVar;
                    if (zzkxVar == null) {
                        synchronized (zzc.class) {
                            try {
                                zzkx<zzc> zzkxVar2 = zzh;
                                r4 = zzkxVar2;
                                if (zzkxVar2 == null) {
                                    ?? zzaVar = new zzjb.zza(zzg);
                                    zzh = zzaVar;
                                    r4 = zzaVar;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                            break;
                        }
                        obj3 = r4;
                    }
                    return obj3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
