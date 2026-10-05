package com.itextpdf.tool.xml.net;

import com.itextpdf.text.Image;
import com.itextpdf.tool.xml.net.exc.NoImageException;
import com.itextpdf.tool.xml.pipeline.html.ImageProvider;
import com.itextpdf.tool.xml.pipeline.html.UrlLinkResolver;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRetrieve {
    private final ImageProvider imageProvider;
    private String resourcesRootPath;

    public ImageRetrieve(String str, ImageProvider imageProvider) {
        this.imageProvider = imageProvider;
        this.resourcesRootPath = str;
    }

    private URL getImageUrl(String str) {
        URL urlResolveUrl;
        UrlLinkResolver urlLinkResolver = new UrlLinkResolver();
        ImageProvider imageProvider = this.imageProvider;
        if (imageProvider != null) {
            urlLinkResolver.setLocalRootPath(imageProvider.getImageRootPath());
            urlResolveUrl = urlLinkResolver.resolveUrl(str);
        } else {
            urlResolveUrl = null;
        }
        if (urlResolveUrl != null) {
            return urlResolveUrl;
        }
        urlLinkResolver.setLocalRootPath(this.resourcesRootPath);
        return urlLinkResolver.resolveUrl(str);
    }

    private Image tryRetrieveImageWithImageProvider(String str) {
        ImageProvider imageProvider = this.imageProvider;
        if (imageProvider != null) {
            return imageProvider.retrieve(str);
        }
        return null;
    }

    public Image retrieveImage(String str) throws NoImageException {
        Image imageTryRetrieveImageWithImageProvider = tryRetrieveImageWithImageProvider(str);
        if (imageTryRetrieveImageWithImageProvider == null) {
            try {
                imageTryRetrieveImageWithImageProvider = Image.getInstance(getImageUrl(str));
            } catch (Exception e) {
                throw new NoImageException(str, e);
            }
        }
        ImageProvider imageProvider = this.imageProvider;
        if (imageProvider != null && imageTryRetrieveImageWithImageProvider != null) {
            imageProvider.store(str, imageTryRetrieveImageWithImageProvider);
        }
        return imageTryRetrieveImageWithImageProvider;
    }

    public ImageRetrieve(String str) {
        this.resourcesRootPath = str;
        this.imageProvider = null;
    }

    public ImageRetrieve(ImageProvider imageProvider) {
        this.imageProvider = imageProvider;
        this.resourcesRootPath = null;
    }

    public ImageRetrieve() {
        this.imageProvider = null;
        this.resourcesRootPath = null;
    }
}
