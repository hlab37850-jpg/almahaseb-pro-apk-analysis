package defpackage;

import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: au, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1748au extends AbstractC0714Ld implements Serializable {
    public final Pattern a;

    /* JADX INFO: renamed from: au$a */
    public static final class a extends AbstractC0688Kd {
        public final Matcher a;

        public a(Matcher matcher) {
            this.a = (Matcher) Preconditions.checkNotNull(matcher);
        }

        @Override // defpackage.AbstractC0688Kd
        public int a() {
            return this.a.end();
        }

        @Override // defpackage.AbstractC0688Kd
        public boolean b() {
            return this.a.find();
        }

        @Override // defpackage.AbstractC0688Kd
        public boolean c(int i) {
            return this.a.find(i);
        }

        @Override // defpackage.AbstractC0688Kd
        public boolean d() {
            return this.a.matches();
        }

        @Override // defpackage.AbstractC0688Kd
        public int e() {
            return this.a.start();
        }
    }

    public C1748au(Pattern pattern) {
        this.a = (Pattern) Preconditions.checkNotNull(pattern);
    }

    @Override // defpackage.AbstractC0714Ld
    public int a() {
        return this.a.flags();
    }

    @Override // defpackage.AbstractC0714Ld
    public AbstractC0688Kd b(CharSequence charSequence) {
        return new a(this.a.matcher(charSequence));
    }

    @Override // defpackage.AbstractC0714Ld
    public String c() {
        return this.a.pattern();
    }

    public String toString() {
        return this.a.toString();
    }
}
