package com.thoughtinterac.realestateapp.CustomAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.thoughtinterac.realestateapp.Activities.ImageZoomActivity;
import com.thoughtinterac.realestateapp.Model.GalleryImagesModel;
import com.thoughtinterac.realestateapp.Model.PlaceModel;
import com.thoughtinterac.realestateapp.R;

import java.util.List;

/**
 * Created by AzaharSheikh on 03-10-2016.
 */
public class GalleryImagesAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<GalleryImagesModel> imageItems;
    public GalleryImagesAdapter(Activity activity, List<GalleryImagesModel> imageItems) {
        this.activity = activity;
        this.imageItems = imageItems;
    }


    @Override
    public int getCount() {
        return imageItems.size();
    }

    @Override
    public Object getItem(int position) {
        return imageItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.gallery_row_layout, null);
        ImageView img_single_image=(ImageView)convertView.findViewById(R.id.img_single_image);
        LinearLayout li_main=(LinearLayout)convertView.findViewById(R.id.li_main);
        final GalleryImagesModel m = imageItems.get(position);

        li_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
               Toast.makeText(activity,m.getImg_name(), Toast.LENGTH_LONG).show();

               Intent i = new Intent(activity, ImageZoomActivity.class);
                bundle.putString("img_id", m.getImage_id()+"");
                bundle.putString("img_name", m.getImg_name());
                i.putExtras(bundle);
                activity.startActivity(i);
            }
        });
        li_main.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Drawable myDrawable = activity.getResources().getDrawable(m.getImage_id());
                Bitmap anImage      = ((BitmapDrawable) myDrawable).getBitmap();
                String pathofBmp = MediaStore.Images.Media.insertImage(activity.getContentResolver(), anImage,m.getImg_name(), null);
                Uri bmpUri = Uri.parse(pathofBmp);
                final Intent emailIntent1 = new Intent(     android.content.Intent.ACTION_SEND);
                emailIntent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                emailIntent1.putExtra(Intent.EXTRA_STREAM, bmpUri);
                emailIntent1.setType("image/png");
                return true;
            }
        });
        img_single_image.setImageResource(m.getImage_id());
//setImage
        return convertView;
    }
}
