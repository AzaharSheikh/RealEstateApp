package com.thoughtinterac.realestateapp.Activities;

import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.thoughtinterac.realestateapp.R;

/**
 * Created by AzaharSheikh on 03-10-2016.
 */
public class ImageZoomActivity extends AppCompatActivity {
    int img_id;
    String img_name;
    ImageView img_zoom_view;
    private ScaleGestureDetector scaleGestureDetector;
    private Matrix matrix = new Matrix();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_zoom_layout);
        img_zoom_view=(ImageView)findViewById(R.id.img_zoom_view);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            img_id = Integer.parseInt(bundle.getString("img_id"));
            img_name = bundle.getString("img_name");



        }else
        {
            return;
        }
        scaleGestureDetector = new ScaleGestureDetector(this,new ScaleListener());
        img_zoom_view.setImageResource(img_id);
    }
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        scaleGestureDetector.onTouchEvent(ev);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.
            SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            float scaleFactor = detector.getScaleFactor();
            scaleFactor = Math.max(0.1f, Math.min(scaleFactor, 5.0f));
            matrix.setScale(scaleFactor, scaleFactor);
            img_zoom_view.setImageMatrix(matrix);
            return true;
        }
    }
}
