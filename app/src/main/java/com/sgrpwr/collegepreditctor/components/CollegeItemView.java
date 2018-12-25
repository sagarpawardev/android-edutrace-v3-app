package com.sgrpwr.collegepreditctor.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.sgrpwr.collegepreditctor.R;

/**
 * TODO: document your custom view class.
 */
public class CollegeItemView extends CardView {


    public CollegeItemView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CollegeItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CollegeItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_college_item_view, this);

        /*ImageView mImgIcon = view.findViewById(R.id.img_iconview);
        TextView mText = view.findViewById(R.id.tv_iconview);/*

        /*if(attrs!=null){

            TypedArray typedArray = context.obtainStyledAttributes(attrs,
                    R.styleable.IconView, defStyleAttr, defStyleRes);

            Drawable imgIcon = typedArray.getDrawable(R.styleable.IconView_src);
            mImgIcon.setImageDrawable(imgIcon);
            String text = typedArray.getString(R.styleable.IconView_text);
            mText.setText(text);

            typedArray.recycle();
        }*/
    }


}
