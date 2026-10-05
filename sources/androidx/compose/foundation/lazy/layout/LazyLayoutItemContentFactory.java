package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import defpackage.AbstractC4492zt;
import defpackage.InterfaceC0526Fp;
import defpackage.InterfaceC3588op;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyLayoutItemContentFactory {
    private final InterfaceC3588op itemProvider;
    private final Map<Object, CachedItemContent> lambdasCache;
    private final SaveableStateHolder saveableStateHolder;

    public final class CachedItemContent {
        private InterfaceC0526Fp _content;
        private final Object contentType;
        private int index;
        private final Object key;
        final /* synthetic */ LazyLayoutItemContentFactory this$0;

        public CachedItemContent(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, int i, Object obj, Object obj2) {
            AbstractC4492zt.h(obj, "key");
            this.this$0 = lazyLayoutItemContentFactory;
            this.key = obj;
            this.contentType = obj2;
            this.index = i;
        }

        private final InterfaceC0526Fp createContentLambda() {
            return ComposableLambdaKt.composableLambdaInstance(1403994769, true, new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(this.this$0, this));
        }

        public final InterfaceC0526Fp getContent() {
            InterfaceC0526Fp interfaceC0526Fp = this._content;
            if (interfaceC0526Fp != null) {
                return interfaceC0526Fp;
            }
            InterfaceC0526Fp interfaceC0526FpCreateContentLambda = createContentLambda();
            this._content = interfaceC0526FpCreateContentLambda;
            return interfaceC0526FpCreateContentLambda;
        }

        public final Object getContentType() {
            return this.contentType;
        }

        public final int getIndex() {
            return this.index;
        }

        public final Object getKey() {
            return this.key;
        }
    }

    public LazyLayoutItemContentFactory(SaveableStateHolder saveableStateHolder, InterfaceC3588op interfaceC3588op) {
        AbstractC4492zt.h(saveableStateHolder, "saveableStateHolder");
        AbstractC4492zt.h(interfaceC3588op, "itemProvider");
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = interfaceC3588op;
        this.lambdasCache = new LinkedHashMap();
    }

    public final InterfaceC0526Fp getContent(int i, Object obj, Object obj2) {
        AbstractC4492zt.h(obj, "key");
        CachedItemContent cachedItemContent = this.lambdasCache.get(obj);
        if (cachedItemContent != null && cachedItemContent.getIndex() == i && AbstractC4492zt.d(cachedItemContent.getContentType(), obj2)) {
            return cachedItemContent.getContent();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(this, i, obj, obj2);
        this.lambdasCache.put(obj, cachedItemContent2);
        return cachedItemContent2.getContent();
    }

    public final Object getContentType(Object obj) {
        if (obj == null) {
            return null;
        }
        CachedItemContent cachedItemContent = this.lambdasCache.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.getContentType();
        }
        LazyLayoutItemProvider lazyLayoutItemProvider = (LazyLayoutItemProvider) this.itemProvider.invoke();
        int index = lazyLayoutItemProvider.getIndex(obj);
        if (index != -1) {
            return lazyLayoutItemProvider.getContentType(index);
        }
        return null;
    }

    public final InterfaceC3588op getItemProvider() {
        return this.itemProvider;
    }
}
