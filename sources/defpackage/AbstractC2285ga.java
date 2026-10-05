package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: ga, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2285ga implements InterfaceC0609Iu, Serializable {
    public static final Object NO_RECEIVER = a.a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient InterfaceC0609Iu reflected;
    private final String signature;

    /* JADX INFO: renamed from: ga$a */
    public static class a implements Serializable {
        public static final a a = new a();
    }

    public AbstractC2285ga(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // defpackage.InterfaceC0609Iu
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // defpackage.InterfaceC0609Iu
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public InterfaceC0609Iu compute() {
        InterfaceC0609Iu interfaceC0609Iu = this.reflected;
        if (interfaceC0609Iu != null) {
            return interfaceC0609Iu;
        }
        InterfaceC0609Iu interfaceC0609IuComputeReflected = computeReflected();
        this.reflected = interfaceC0609IuComputeReflected;
        return interfaceC0609IuComputeReflected;
    }

    public abstract InterfaceC0609Iu computeReflected();

    @Override // defpackage.InterfaceC0583Hu
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public InterfaceC0705Ku getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? QJ.c(cls) : QJ.b(cls);
    }

    @Override // defpackage.InterfaceC0609Iu
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public InterfaceC0609Iu getReflected() {
        InterfaceC0609Iu interfaceC0609IuCompute = compute();
        if (interfaceC0609IuCompute != this) {
            return interfaceC0609IuCompute;
        }
        throw new C1749av();
    }

    @Override // defpackage.InterfaceC0609Iu
    public InterfaceC1071Xu getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // defpackage.InterfaceC0609Iu
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // defpackage.InterfaceC0609Iu
    public EnumC1097Yu getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // defpackage.InterfaceC0609Iu
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // defpackage.InterfaceC0609Iu
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // defpackage.InterfaceC0609Iu
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // defpackage.InterfaceC0609Iu
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
