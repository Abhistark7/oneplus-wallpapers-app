package com.whiteturtlestudio.oneplus5twalls;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;



public class ImageAdapter extends BaseAdapter
{
    private Context context;

    public Integer[] images = {
            R.drawable.image0000,
            R.drawable.image000,
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10,
            R.drawable.image11,
            R.drawable.image12,
            R.drawable.image13,
            R.drawable.image14,
            R.drawable.image15,
            R.drawable.image16,
            R.drawable.image17,
            R.drawable.image18,
            R.drawable.image19,
            R.drawable.image20,
            R.drawable.image21,
            R.drawable.image22



    };


    public ImageAdapter(Context c)
    {
        context = c;
    }

    //---returns the number of images---
    public int getCount() {
        return images.length;
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
            imageView = new ImageView(context);
            //imageView.setLayoutParams(new GridView.LayoutParams(375, 375));
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(images[position]);
        return imageView;
    }
}