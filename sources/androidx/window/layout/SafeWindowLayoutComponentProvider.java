package androidx.window.layout;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.layout.WindowLayoutComponent;
import defpackage.AbstractC0557Gu;
import defpackage.AbstractC2233fv;
import defpackage.AbstractC3756qv;
import defpackage.AbstractC3956tN;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0635Ju;
import defpackage.InterfaceC3430mv;
import defpackage.InterfaceC3588op;
import defpackage.QJ;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* JADX INFO: loaded from: classes2.dex */
public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider INSTANCE = new SafeWindowLayoutComponentProvider();
    private static final InterfaceC3430mv windowLayoutComponent$delegate = AbstractC3756qv.a(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            Class clsFoldingFeatureClass = safeWindowLayoutComponentProvider.foldingFeatureClass(this.$classLoader);
            boolean z = false;
            Method method = clsFoldingFeatureClass.getMethod("getBounds", new Class[0]);
            Method method2 = clsFoldingFeatureClass.getMethod("getType", new Class[0]);
            Method method3 = clsFoldingFeatureClass.getMethod("getState", new Class[0]);
            AbstractC4492zt.g(method, "getBoundsMethod");
            if (safeWindowLayoutComponentProvider.doesReturn(method, QJ.b(Rect.class)) && safeWindowLayoutComponentProvider.isPublic(method)) {
                AbstractC4492zt.g(method2, "getTypeMethod");
                Class cls = Integer.TYPE;
                if (safeWindowLayoutComponentProvider.doesReturn(method2, QJ.b(cls)) && safeWindowLayoutComponentProvider.isPublic(method2)) {
                    AbstractC4492zt.g(method3, "getStateMethod");
                    if (safeWindowLayoutComponentProvider.doesReturn(method3, QJ.b(cls)) && safeWindowLayoutComponentProvider.isPublic(method3)) {
                        z = true;
                    }
                }
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17351 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17351(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            boolean z = false;
            Method method = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader).getMethod("getWindowLayoutComponent", new Class[0]);
            Class clsWindowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
            AbstractC4492zt.g(method, "getWindowLayoutComponentMethod");
            if (safeWindowLayoutComponentProvider.isPublic(method)) {
                AbstractC4492zt.g(clsWindowLayoutComponentClass, "windowLayoutComponentClass");
                if (safeWindowLayoutComponentProvider.doesReturn(method, (Class<?>) clsWindowLayoutComponentClass)) {
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17361 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17361(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            Class clsWindowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
            boolean z = false;
            Method method = clsWindowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Activity.class, AbstractC3956tN.a());
            Method method2 = clsWindowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", AbstractC3956tN.a());
            AbstractC4492zt.g(method, "addListenerMethod");
            if (safeWindowLayoutComponentProvider.isPublic(method)) {
                AbstractC4492zt.g(method2, "removeListenerMethod");
                if (safeWindowLayoutComponentProvider.isPublic(method2)) {
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C17371 extends AbstractC2233fv implements InterfaceC3588op {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C17371(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        @Override // defpackage.InterfaceC3588op
        public final Boolean invoke() throws NoSuchMethodException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            boolean z = false;
            Method declaredMethod = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(this.$classLoader).getDeclaredMethod("getWindowExtensions", new Class[0]);
            Class clsWindowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader);
            AbstractC4492zt.g(declaredMethod, "getWindowExtensionsMethod");
            AbstractC4492zt.g(clsWindowExtensionsClass, "windowExtensionsClass");
            if (safeWindowLayoutComponentProvider.doesReturn(declaredMethod, (Class<?>) clsWindowExtensionsClass) && safeWindowLayoutComponentProvider.isPublic(declaredMethod)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    private SafeWindowLayoutComponentProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canUseWindowLayoutComponent(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && isWindowLayoutProviderValid(classLoader) && isWindowExtensionsValid(classLoader) && isWindowLayoutComponentValid(classLoader) && isFoldingFeatureValid(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, InterfaceC0635Ju interfaceC0635Ju) {
        return doesReturn(method, AbstractC0557Gu.a(interfaceC0635Ju));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> foldingFeatureClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean isFoldingFeatureValid(ClassLoader classLoader) {
        return validate(new AnonymousClass1(classLoader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean isWindowExtensionsValid(ClassLoader classLoader) {
        return validate(new C17351(classLoader));
    }

    @RequiresApi(24)
    private final boolean isWindowLayoutComponentValid(ClassLoader classLoader) {
        return validate(new C17361(classLoader));
    }

    private final boolean isWindowLayoutProviderValid(ClassLoader classLoader) {
        return validate(new C17371(classLoader));
    }

    private final boolean validate(InterfaceC3588op interfaceC3588op) {
        try {
            return ((Boolean) interfaceC3588op.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsProviderClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowLayoutComponentClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        return (WindowLayoutComponent) windowLayoutComponent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
