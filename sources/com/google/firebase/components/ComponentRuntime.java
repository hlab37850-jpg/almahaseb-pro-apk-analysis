package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import defpackage.AbstractC2299gh;
import defpackage.C0344Al;
import defpackage.C4301xe;
import defpackage.C4382ye;
import defpackage.C4473ze;
import defpackage.E;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public class ComponentRuntime extends E {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = C4473ze.a();
    private final C0344Al eventBus;
    private final Map<Component<?>, Lazy<?>> components = new HashMap();
    private final Map<Class<?>, Lazy<?>> lazyInstanceMap = new HashMap();
    private final Map<Class<?>, Lazy<Set<?>>> lazySetMap = new HashMap();

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        C0344Al c0344Al = new C0344Al(executor);
        this.eventBus = c0344Al;
        ArrayList<Component<?>> arrayList = new ArrayList();
        arrayList.add(Component.of(c0344Al, C0344Al.class, Subscriber.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        for (Component<?> component : componentArr) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        AbstractC2299gh.a(arrayList);
        for (Component<?> component2 : arrayList) {
            this.components.put(component2, new Lazy<>(C4301xe.a(this, component2)));
        }
        processInstanceComponents();
        processSetComponents();
    }

    public static /* synthetic */ Set lambda$processSetComponents$1(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private void processInstanceComponents() {
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (key.isValue()) {
                Lazy<?> value = entry.getValue();
                Iterator<Class<? super Object>> it = key.getProvidedInterfaces().iterator();
                while (it.hasNext()) {
                    this.lazyInstanceMap.put(it.next(), value);
                }
            }
        }
        validateDependencies();
    }

    private void processSetComponents() {
        HashMap map = new HashMap();
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.isValue()) {
                Lazy<?> value = entry.getValue();
                for (Class<? super Object> cls : key.getProvidedInterfaces()) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            this.lazySetMap.put((Class) entry2.getKey(), new Lazy<>(C4382ye.a((Set) entry2.getValue())));
        }
    }

    private void validateDependencies() {
        for (Component<?> component : this.components.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isRequired() && !this.lazyInstanceMap.containsKey(dependency.getInterface())) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.getInterface()));
                }
            }
        }
    }

    @Override // defpackage.E, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.lazyInstanceMap.get(cls);
    }

    public void initializeEagerComponents(boolean z) {
        for (Map.Entry<Component<?>, Lazy<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            Lazy<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z)) {
                value.get();
            }
        }
        this.eventBus.a();
    }

    @Override // defpackage.E, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        Lazy<Set<?>> lazy = this.lazySetMap.get(cls);
        return lazy != null ? lazy : (Provider<Set<T>>) EMPTY_PROVIDER;
    }
}
