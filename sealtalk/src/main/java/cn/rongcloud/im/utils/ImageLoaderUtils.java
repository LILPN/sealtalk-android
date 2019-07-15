package cn.rongcloud.im.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

import cn.rongcloud.im.R;
import io.rong.imageloader.core.DisplayImageOptions;
import io.rong.imageloader.core.ImageLoader;

import static io.rong.imageloader.core.assist.ImageScaleType.IN_SAMPLE_POWER_OF_2;

public class ImageLoaderUtils {


     private static DisplayImageOptions privateOptions;
     private static DisplayImageOptions groupOptions;

     static {
         privateOptions = createDefaultDisplayOptions(R.drawable.rc_default_portrait);
         groupOptions = createDefaultDisplayOptions(R.drawable.rc_default_group_portrait);
     }

    public static void displayUserPortraitImage(String uri, ImageView imageView) {
        ImageLoader.getInstance().displayImage(uri, imageView, privateOptions);
//        ImageLoader.getInstance().displayImage(uri, imageView, privateOptions, null);
    }


    public static void displayGroupPortraitImage(String uri, ImageView imageView) {
        ImageLoader.getInstance().displayImage(uri, imageView, groupOptions, null);
    }


    private static DisplayImageOptions createDefaultDisplayOptions(int defaultImgId) {
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.showImageOnLoading(defaultImgId == 0 ? R.drawable.rc_default_portrait : defaultImgId) //设置加载失败的图片
                .showImageOnFail(defaultImgId == 0 ? R.drawable.rc_default_portrait : defaultImgId)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(IN_SAMPLE_POWER_OF_2)
                .considerExifParams(true)
                .build();
        return builder.build();
    }
}
