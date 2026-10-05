package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: renamed from: Us, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0975Us extends AbstractC0919Ss {
    public final int a;
    public final int b;
    public boolean c;
    public int d;

    public C0975Us(int i, int i2, int i3) {
        this.a = i3;
        this.b = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.c = z;
        this.d = z ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.c;
    }

    @Override // defpackage.AbstractC0919Ss
    public int nextInt() {
        int i = this.d;
        if (i != this.b) {
            this.d = this.a + i;
        } else {
            if (!this.c) {
                throw new NoSuchElementException();
            }
            this.c = false;
        }
        return i;
    }
}
