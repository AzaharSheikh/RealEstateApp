package com.thoughtinterac.realestateapp.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by AzaharSheikh on 06-10-2016.
 */
public class TypefacedTextView extends TextView {

    public TypefacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/LatoBlack.ttf");
        setTypeface(typeface);
    }
}