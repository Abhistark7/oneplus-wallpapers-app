package com.whiteturtlestudio.oneplus5twalls;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;



public class ImageAdapterT extends BaseAdapter
{
    private Context context;

    public Integer[] thumb = {
            R.drawable.thumb0000,
            R.drawable.thumb000,
            R.drawable.thumb1,
            R.drawable.thumb2,
            R.drawable.thumb3,
            R.drawable.thumb4,
            R.drawable.thumb5,
            R.drawable.thumb6,
            R.drawable.thumb7,
            R.drawable.thumb8,
            R.drawable.thumb9,
            R.drawable.thumb10,
            R.drawable.thumb11,
            R.drawable.thumb12,
            R.drawable.thumb13,
            R.drawable.thumb14,
            R.drawable.thumb15,
            R.drawable.thumb16,
            R.drawable.thumb17,
            R.drawable.thumb18,
            R.drawable.thumb19,
            R.drawable.thumb20,
            R.drawable.thumb21,
            R.drawable.thumb22


    };

    public ImageAdapterT(Context c)
    {
        context = c;
    }

    //---returns the number of images---
    public int getCount() {
        return thumb.length;
    }

    //---returns the ID of an item---
    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    //---returns an ImageView view---
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView;
        if (convertView == null) {
            Resources r = Resources.getSystem();
            imageView = new ImageView(context);
            final DisplayMetrics displayMetrics=r.getDisplayMetrics();
            final int screenWidthInDp =displayMetrics.widthPixels;
            int cw = (screenWidthInDp/2);
            imageView.setLayoutParams(new GridView.LayoutParams(cw,cw));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(5, 5, 5, 5);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(thumb[position]);
        return imageView;
    }

}