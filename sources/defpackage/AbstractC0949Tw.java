package defpackage;

import android.hardware.fingerprint.FingerprintManager;
import javax.crypto.Cipher;

/* JADX INFO: renamed from: Tw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class AbstractC0949Tw {
    public static /* synthetic */ FingerprintManager.CryptoObject a(Cipher cipher) {
        return new FingerprintManager.CryptoObject(cipher);
    }
}
