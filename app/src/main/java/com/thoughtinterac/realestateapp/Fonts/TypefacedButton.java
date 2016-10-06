package com.thoughtinterac.realestateapp.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AzaharSheikh on 06-10-2016.
 */
public class TypefacedButton extends Button {

    public TypefacedButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/LatoRegular.ttf");
        setTypeface(typeface);
    }
}