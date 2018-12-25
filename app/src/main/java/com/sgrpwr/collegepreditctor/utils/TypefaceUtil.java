package com.sgrpwr.collegepreditctor.utils;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by sagar on 18/4/17.
 */

public class TypefaceUtil {

    //--Sample Usage
    //Typeface typeface = TypefaceUtil.juliousSans(this);
    //tv.setTypeface(typeface);
    public static Typeface juliousSans(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/JuliusSansOne-Regular.ttf");
    }

    public static Typeface robotoCondensed(Context context){
        //return Typeface.createFromAsset(context.getAssets(),"fonts/RobotoCondensed-Regular.ttf");
        return Typeface.DEFAULT;
    }

    public static Typeface robotoBold(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/RobotoCondensed-Bold.ttf");
    }

    public static Typeface confortaRegular(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/Comfortaa-Regular.ttf");
    }

    public static Typeface confortaBold(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/Comfortaa-Bold.ttf");
    }

    public static Typeface maze(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/maze.ttf");
    }

    public static Typeface varelaRound(Context context){
        return Typeface.createFromAsset(context.getAssets(),"fonts/VarelaRound-Regular.ttf");
    }
}
