package androidx.compose.ui;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import defpackage.AbstractC0956Ud;
import defpackage.AbstractC4492zt;
import defpackage.R5;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ActualKt {
    public static final boolean areObjectsOfSameType(Object obj, Object obj2) {
        AbstractC4492zt.h(obj, "a");
        AbstractC4492zt.h(obj2, "b");
        return obj.getClass() == obj2.getClass();
    }

    public static final void tryPopulateReflectively(InspectorInfo inspectorInfo, ModifierNodeElement<?> modifierNodeElement) {
        AbstractC4492zt.h(inspectorInfo, "<this>");
        AbstractC4492zt.h(modifierNodeElement, "element");
        Field[] declaredFields = modifierNodeElement.getClass().getDeclaredFields();
        AbstractC4492zt.g(declaredFields, "element.javaClass.declaredFields");
        List listG0 = R5.g0(declaredFields, new Comparator() { // from class: androidx.compose.ui.ActualKt$tryPopulateReflectively$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return AbstractC0956Ud.d(((Field) t).getName(), ((Field) t2).getName());
            }
        });
        int size = listG0.size();
        for (int i = 0; i < size; i++) {
            Field field = (Field) listG0.get(i);
            if (!field.getDeclaringClass().isAssignableFrom(ModifierNodeElement.class)) {
                try {
                    field.setAccessible(true);
                    ValueElementSequence properties = inspectorInfo.getProperties();
                    String name = field.getName();
                    AbstractC4492zt.g(name, "field.name");
                    properties.set(name, field.get(modifierNodeElement));
                } catch (IllegalAccessException | SecurityException unused) {
                }
            }
        }
    }
}
