package com.itextpdf.tool.xml.html;

import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.NoTagProcessorException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultTagProcessorFactory implements TagProcessorFactory {
    private final Map<String, FactoryObject> map = new ConcurrentHashMap();

    public void addProcessor(String str, String str2) {
        this.map.put(str, new FactoryObject(str2));
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessorFactory
    public TagProcessor getProcessor(String str, String str2) {
        FactoryObject factoryObject = this.map.get(str.toLowerCase());
        if (factoryObject != null) {
            return factoryObject.getProcessor();
        }
        throw new NoTagProcessorException(str);
    }

    public TagProcessor load(String str) {
        try {
            return (TagProcessor) Class.forName(str).newInstance();
        } catch (ClassNotFoundException e) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str), e);
        } catch (IllegalAccessException e2) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str), e2);
        } catch (InstantiationException e3) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str), e3);
        } catch (LinkageError unused) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str));
        }
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessorFactory
    public void removeProcessor(String str) {
        this.map.remove(str);
    }

    public final class FactoryObject {
        private final String className;
        private TagProcessor proc;

        public FactoryObject(String str) {
            this.className = str;
        }

        public String getClassName() {
            return this.className;
        }

        public TagProcessor getProcessor() {
            if (this.proc == null) {
                this.proc = DefaultTagProcessorFactory.this.load(this.className);
            }
            return this.proc;
        }

        public FactoryObject(DefaultTagProcessorFactory defaultTagProcessorFactory, String str, TagProcessor tagProcessor) {
            this(str);
            this.proc = tagProcessor;
        }
    }

    public void addProcessor(String str, TagProcessor tagProcessor) {
        this.map.put(str, new FactoryObject(this, tagProcessor.getClass().getName(), tagProcessor));
    }

    @Override // com.itextpdf.tool.xml.html.TagProcessorFactory
    public void addProcessor(TagProcessor tagProcessor, String... strArr) {
        for (String str : strArr) {
            addProcessor(str, tagProcessor);
        }
    }

    public void addProcessor(String str, String... strArr) {
        for (String str2 : strArr) {
            addProcessor(str2, str);
        }
    }

    public TagProcessor load(String str, ClassLoader classLoader) {
        try {
            return (TagProcessor) classLoader.loadClass(str).newInstance();
        } catch (ClassNotFoundException e) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str), e);
        } catch (IllegalAccessException e2) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str), e2);
        } catch (InstantiationException e3) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str), e3);
        } catch (LinkageError unused) {
            throw new NoTagProcessorException(String.format(LocaleMessages.getInstance().getMessage(LocaleMessages.NO_TAGPROCESSOR), str));
        }
    }
}
