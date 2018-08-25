package com.lazday.fanlistview.utils;

import android.widget.ImageView;

import com.lazday.fanlistview.R;
import com.squareup.picasso.Picasso;

public class DownloadImage {
    public static void picasso(String url, ImageView imageView){
        Picasso.get().load(url).placeholder(R.drawable.ic_filter_hdr).error(R.drawable.ic_filter_hdr)
                .fit().centerCrop().into(imageView);
    }
}
