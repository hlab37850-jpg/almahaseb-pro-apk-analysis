package com.itextpdf.tool.xml.net;

import com.itextpdf.text.log.Level;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.tool.xml.exceptions.LocaleMessages;
import com.itextpdf.tool.xml.exceptions.RuntimeWorkerException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class FileRetrieveImpl implements FileRetrieve {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) FileRetrieveImpl.class);
    private final List<File> rootdirs;
    private final List<String> urls;

    public FileRetrieveImpl() {
        this.rootdirs = new CopyOnWriteArrayList();
        this.urls = new CopyOnWriteArrayList();
    }

    private URL detectWithRootUrls(String str) throws MalformedURLException {
        Iterator<String> it = this.urls.iterator();
        while (it.hasNext()) {
            try {
                return new URL(it.next() + str);
            } catch (MalformedURLException unused) {
            }
        }
        throw new MalformedURLException();
    }

    private void read(ReadingProcessor readingProcessor, InputStream inputStream) {
        while (true) {
            try {
                try {
                    int i = inputStream.read();
                    if (i == -1) {
                        try {
                            inputStream.close();
                            return;
                        } catch (IOException e) {
                            throw new RuntimeWorkerException(e);
                        }
                    }
                    readingProcessor.process(i);
                } catch (IOException e2) {
                    throw e2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        throw new RuntimeWorkerException(e3);
                    }
                }
                throw th;
            }
        }
    }

    public void addRootDir(File file) {
        this.rootdirs.add(file);
    }

    public void addURL(String str) {
        this.urls.add(str);
    }

    @Override // com.itextpdf.tool.xml.net.FileRetrieve
    public void processFromHref(String str, ReadingProcessor readingProcessor) throws IOException {
        File file;
        InputStream fileInputStream;
        boolean z = false;
        Logger logger = LOGGER;
        if (logger.isLogging(Level.DEBUG)) {
            logger.debug(String.format(LocaleMessages.getInstance().getMessage("retrieve.file.from"), str));
        }
        URL urlDetectWithRootUrls = null;
        try {
            try {
                file = null;
                urlDetectWithRootUrls = new URL(str);
            } catch (MalformedURLException unused) {
                file = null;
                urlDetectWithRootUrls = detectWithRootUrls(str);
            }
        } catch (MalformedURLException unused2) {
            file = new File(str);
            if (!file.isFile() || !file.canRead()) {
                Iterator<File> it = this.rootdirs.iterator();
                while (it.hasNext()) {
                    File file2 = new File(it.next(), str);
                    if (file2.isFile() && file2.canRead()) {
                        file = file2;
                        z = true;
                        break;
                    }
                    file = file2;
                }
            } else {
                z = true;
                break;
            }
        }
        if (urlDetectWithRootUrls != null) {
            fileInputStream = urlDetectWithRootUrls.openStream();
        } else {
            if (!z) {
                throw new IOException(LocaleMessages.getInstance().getMessage("retrieve.file.from.nothing"));
            }
            fileInputStream = new FileInputStream(file);
        }
        read(readingProcessor, fileInputStream);
    }

    @Override // com.itextpdf.tool.xml.net.FileRetrieve
    public void processFromStream(InputStream inputStream, ReadingProcessor readingProcessor) {
        read(readingProcessor, inputStream);
    }

    public FileRetrieveImpl(String... strArr) {
        this();
        for (String str : strArr) {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                File file = new File(str);
                if (file.isDirectory()) {
                    this.rootdirs.add(file);
                }
            } else {
                this.urls.add(str);
            }
        }
    }

    public FileRetrieveImpl(File file) {
        this();
        if (file.isDirectory()) {
            this.rootdirs.add(file);
        }
    }
}
