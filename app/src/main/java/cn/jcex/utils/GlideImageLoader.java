package cn.jcex.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

import cn.jcex.R;

/**
 * 类描述:glide加载图片
 *
 * @author Sunyaqin
 * @data 2018/4/4  14:37
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
        Glide.with(context)
                .load(path)
                .placeholder(R.mipmap.pic_home_banner_1)
                .into(imageView);
    }


}
