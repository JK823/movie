package com.bw.movie.util;

import android.net.Uri;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.common.util.ByteConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class FrescoUtils {
    public static void initFresco(){
        DiskCacheConfig diskCacheConfig = DiskCacheConfig.newBuilder(AppContext.context)
                // .setBaseDirectoryPath(new File(AppSettings.AppFilePathDir + "/caches"))
                .setBaseDirectoryName("rsSystemPicCache").setMaxCacheSize(200 * ByteConstants.MB)
                .setMaxCacheSizeOnLowDiskSpace(100 * ByteConstants.MB)
                .setMaxCacheSizeOnVeryLowDiskSpace(50 * ByteConstants.MB)
                .setMaxCacheSize(80 * ByteConstants.MB).build();
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(AppContext.context)
                .setMainDiskCacheConfig(diskCacheConfig)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(AppContext.context, config);
    }

    public static DraweeController getLisPicController(String photoUrl) {
        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(photoUrl)).
                setResizeOptions(
                        new ResizeOptions(200, 140)).build();
        return Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setAutoPlayAnimations(true)
                .setTapToRetryEnabled(true).build();
    }
}
