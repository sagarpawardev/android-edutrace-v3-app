package com.sgrpwr.collegepreditctor.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sgrpwr.collegepreditctor.R;

public class IconView extends LinearLayout {

    public IconView(Context context) {
        super(context);
        initializeViews(context, null, 0, 0);
    }

    public IconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context, attrs, 0,0 );
    }

    public IconView(Context context,
                       AttributeSet attrs,
                       int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context, attrs, defStyle, 0);
    }

    /**
     * Inflates the views in the layout.
     *
     * @param context
     *           the current context for the view.
     */
    private void initializeViews(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_icon_view, this);

        ImageView mImgIcon = view.findViewById(R.id.img_iconview);
        TextView mText = view.findViewById(R.id.tv_iconview);

        if(attrs!=null){

            TypedArray typedArray = context.obtainStyledAttributes(attrs,
                    R.styleable.IconView, defStyleAttr, defStyleRes);

            Drawable imgIcon = typedArray.getDrawable(R.styleable.IconView_src);
            mImgIcon.setImageDrawable(imgIcon);
            String text = typedArray.getString(R.styleable.IconView_text);
            mText.setText(text);

            typedArray.recycle();
        }
    }

}
