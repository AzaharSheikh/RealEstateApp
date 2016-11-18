package com.thoughtinterac.realestateapp.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by AzaharSheikh on 06-10-2016.
 */
public class TypefacedTextView2 extends TextView {

    public TypefacedTextView2(Context context, AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/impact_0.ttf");
        setTypeface(typeface);
    }
}