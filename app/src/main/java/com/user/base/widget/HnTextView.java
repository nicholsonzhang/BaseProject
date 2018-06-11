package com.user.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.base.library.utils.DeviceUtils;
import com.user.base.R;


/**
 * Created by user on 2017/10/11.
 * hn 通用TextView
 */

public class HnTextView extends RelativeLayout {
    private Context mContext;

    private int defaultTextSize;
    private int defaultMargin;
    private int defaultTextColor = 0xFF333333;//默认字体颜色
    private int defaultDividerLineColor = 0xffdddddd;//默认分割线颜色

    private static final int NONE = 0;
    private static final int TOP = 1;
    private static final int BOTTOM = 2;
    private static final int BOTH = 3;
    private int defaultDividerLineType = BOTTOM;



    private String mLeftTextString;
    private String mRightTextString;
    private String mCenterTextString;


    private Drawable mLeftIconRes;
    private Drawable mRightIconRes;
    private int mLeftIconHeight;
    private int mLeftIconWidth;
    private int mRightIconHeight;
    private int mRightIconWidth;
    private int mLeftIconMarginLeft;
    private int mRightIconMarginRight;
    private int mLeftTextMarginLeft;
    private int mLeftTextMarginRight;
    private int mRightTextMarginLeft;
    private int mRightTextMarginRight;
    private int mCenterTextMarginLeft;
    private int mCenterTextMarginRight;
    private int mBottomDividerLineMarginLeft;


    private int mLeftTextSize;
    private int mRightTextSize;
    private int mCenterTextSize;

    private int mLeftTextColor;
    private int mRightTextColor;
    private int mCenterTextColor;

    private int mDividerLineColor;
    private int mDividerLineHeight;
    private int mDividerLineType;

    private ImageView mLeftIconIV,mRightIconIV;
    private TextView mLeftTextTV,mCenterTextTV,mRightTextTV;
    private View mTopDividerLineView,mBottomDividerLineView;


    public HnTextView(Context context) {
        this(context,null);
    }

    public HnTextView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HnTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        defaultTextSize = DeviceUtils.dp2px(17);
        defaultMargin = DeviceUtils.dp2px(10);
        initAttr(attrs);
        initView();
    }

    private void initAttr(AttributeSet attrs){
        TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.HnTextView);

        mLeftTextString = a.getString(R.styleable.HnTextView_leftText);
        mRightTextString = a.getString(R.styleable.HnTextView_rightText);
        mCenterTextString = a.getString(R.styleable.HnTextView_centerText);

        mLeftIconRes = a.getDrawable(R.styleable.HnTextView_leftIcon);
        mRightIconRes = a.getDrawable(R.styleable.HnTextView_rightIcon);

        mLeftTextSize = a.getDimensionPixelSize(R.styleable.HnTextView_leftTextSize,defaultTextSize);
        mRightTextSize = a.getDimensionPixelSize(R.styleable.HnTextView_rightTextSize,defaultTextSize);
        mCenterTextSize = a.getDimensionPixelSize(R.styleable.HnTextView_centerTextSize,defaultTextSize);

        mLeftTextColor = a.getColor(R.styleable.HnTextView_leftTextColor,defaultTextColor);
        mRightTextColor = a.getColor(R.styleable.HnTextView_rightTextColor,defaultTextColor);
        mCenterTextColor = a.getColor(R.styleable.HnTextView_centerTextColor,defaultTextColor);

        mDividerLineColor = a.getColor(R.styleable.HnTextView_dividerLineColor,defaultDividerLineColor);
        mDividerLineHeight = a.getDimensionPixelSize(R.styleable.HnTextView_dividerLineHeight,DeviceUtils.dp2px(0.5f));
        mDividerLineType = a.getInt(R.styleable.HnTextView_dividerLineType,defaultDividerLineType);

        mLeftIconHeight = a.getDimensionPixelSize(R.styleable.HnTextView_leftIconHeight,0);
        mLeftIconWidth = a.getDimensionPixelSize(R.styleable.HnTextView_leftIconWidth,0);
        mRightIconHeight = a.getDimensionPixelSize(R.styleable.HnTextView_rightIconHeight,0);
        mRightIconWidth = a.getDimensionPixelSize(R.styleable.HnTextView_rightIconWidth,0);

        mLeftIconMarginLeft = a.getDimensionPixelSize(R.styleable.HnTextView_leftIconMarginLeft,defaultMargin);
        mRightIconMarginRight = a.getDimensionPixelSize(R.styleable.HnTextView_rightIconMarginRight,defaultMargin);
        mLeftTextMarginLeft = a.getDimensionPixelSize(R.styleable.HnTextView_leftTextMarginLeft,defaultMargin);
        mLeftTextMarginRight = a.getDimensionPixelSize(R.styleable.HnTextView_leftTextMarginRight,defaultMargin);
        mRightTextMarginLeft = a.getDimensionPixelSize(R.styleable.HnTextView_rightTextMarginLeft,defaultMargin);
        mRightTextMarginRight = a.getDimensionPixelSize(R.styleable.HnTextView_rightTextMarginRight,defaultMargin);
        mCenterTextMarginLeft = a.getDimensionPixelSize(R.styleable.HnTextView_centerTextMarginLeft,0);
        mCenterTextMarginRight = a.getDimensionPixelSize(R.styleable.HnTextView_centerTextMarginRight,0);
        mBottomDividerLineMarginLeft = a.getDimensionPixelSize(R.styleable.HnTextView_bottomDividerLineMarginLeft,0);
        a.recycle();
    }
    private void initView(){
        initHnTextView();
        initLeftIcon();
        initLeftTextView();
        initRightIcon();
        initRightTextView();
        initCenterTextView();
        initDividerLineView();
    }
    private void initHnTextView(){
        this.setBackgroundColor(mContext.getResources().getColor(R.color.white));
    }

    private void initLeftIcon(){
        if (mLeftIconIV == null){
            mLeftIconIV = new ImageView(mContext);
        }
        LayoutParams mLeftIconParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mLeftIconParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        mLeftIconParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        if (mLeftIconHeight != 0 && mLeftIconWidth != 0){
            mLeftIconParams.height = mLeftIconHeight;
            mLeftIconParams.width = mLeftIconWidth;
        }
        mLeftIconIV.setId(R.id.leftIconId);
        mLeftIconIV.setLayoutParams(mLeftIconParams);
        if (mLeftIconRes != null){
            mLeftIconParams.setMargins(mLeftIconMarginLeft,0,0,0);
            mLeftIconIV.setImageDrawable(mLeftIconRes);
        }
        addView(mLeftIconIV);
    }

    private void initRightIcon(){
        if (mRightIconIV == null){
            mRightIconIV = new ImageView(mContext);
        }
        LayoutParams mRightIconParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mRightIconParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        mRightIconParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        if (mRightIconHeight != 0 && mRightIconWidth != 0){
            mRightIconParams.height = mRightIconHeight;
            mRightIconParams.width = mRightIconWidth;
        }
        mRightIconIV.setId(R.id.rightIconId);
        mRightIconIV.setLayoutParams(mRightIconParams);
        if (mRightIconRes != null){
            mRightIconParams.setMargins(0,0,mRightIconMarginRight,0);
            mRightIconIV.setImageDrawable(mRightIconRes);
        }
        addView(mRightIconIV);
    }
    private void initLeftTextView(){
        if (mLeftTextTV == null){
            mLeftTextTV = new TextView(mContext);
        }
        LayoutParams mLeftTextParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mLeftTextParams.addRule(RelativeLayout.RIGHT_OF,R.id.leftIconId);
        mLeftTextParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        mLeftTextParams.setMargins(mLeftTextMarginLeft,0,mLeftTextMarginRight,0);
        mLeftTextTV.setId(R.id.leftTextId);
        mLeftTextTV.setLayoutParams(mLeftTextParams);
        mLeftTextTV.setTextColor(mLeftTextColor);
        mLeftTextTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,mLeftTextSize);
        mLeftTextTV.setText(mLeftTextString);
        addView(mLeftTextTV);


    }
    private void initRightTextView(){
        if (mRightTextTV == null){
            mRightTextTV = new TextView(mContext);
        }
        LayoutParams mRightTextParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mRightTextParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        mRightTextParams.addRule(RelativeLayout.LEFT_OF,R.id.rightIconId);
        mRightTextParams.setMargins(mRightTextMarginLeft,0,mRightTextMarginRight,0);
        mRightTextTV.setId(R.id.rightTextId);
        mRightTextTV.setLayoutParams(mRightTextParams);
        mRightTextTV.setTextColor(mRightTextColor);
        mRightTextTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,mRightTextSize);
        mRightTextTV.setText(mRightTextString);
        addView(mRightTextTV);
    }

    private void initCenterTextView(){
        if (mCenterTextTV == null){
            mCenterTextTV = new TextView(mContext);
        }
        LayoutParams mCenterTextParams = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
        mCenterTextParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        mCenterTextParams.addRule(RelativeLayout.LEFT_OF,R.id.rightTextId);
        mCenterTextParams.addRule(RelativeLayout.RIGHT_OF,R.id.leftTextId);
        mCenterTextParams.setMargins(mCenterTextMarginLeft,0,mCenterTextMarginRight,0);

        mCenterTextTV.setLayoutParams(mCenterTextParams);
        mCenterTextTV.setTextColor(mCenterTextColor);
        mCenterTextTV.setTextSize(TypedValue.COMPLEX_UNIT_PX,mCenterTextSize);
        mCenterTextTV.setText(mCenterTextString);
        addView(mCenterTextTV);
    }
    private void initDividerLineView(){
        switch (mDividerLineType){
            case NONE:
                break;
            case TOP:
                initTopDividerLineView();
                break;
            case BOTTOM:
                initBottomDividerLineView();
                break;
            case BOTH:
                initTopDividerLineView();
                initBottomDividerLineView();
                break;
        }
    }

    private void initTopDividerLineView(){
        if (mTopDividerLineView == null){
            mTopDividerLineView = new View(mContext);
            LayoutParams mTopDividerLineParams = new LayoutParams(LayoutParams.MATCH_PARENT,mDividerLineHeight);
            mTopDividerLineParams.addRule(RelativeLayout.ALIGN_PARENT_TOP,TRUE);
            mTopDividerLineView.setLayoutParams(mTopDividerLineParams);
            mTopDividerLineView.setBackgroundColor(mDividerLineColor);
        }
        addView(mTopDividerLineView);
    }
    private void initBottomDividerLineView(){
        if (mBottomDividerLineView == null){
            mBottomDividerLineView = new View(mContext);
            LayoutParams mBottomDividerLineParams = new LayoutParams(LayoutParams.MATCH_PARENT,mDividerLineHeight);
            mBottomDividerLineParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,TRUE);
            mBottomDividerLineParams.setMargins(mBottomDividerLineMarginLeft,0,0,0);
            mBottomDividerLineView.setLayoutParams(mBottomDividerLineParams);
            mBottomDividerLineView.setBackgroundColor(mDividerLineColor);
        }
        addView(mBottomDividerLineView);
    }

    public void setLeftTextString(CharSequence lefString){
        if (mLeftTextTV != null){
            mLeftTextTV.setText(lefString);
        }
    }
    public void setCenterTextString(CharSequence centerString){
        if (mCenterTextTV != null){
            mCenterTextTV.setText(centerString);
        }
    }
    public void setRightTextString(CharSequence rightString){
        if (mRightTextTV != null){
            mRightTextTV.setText(rightString);
        }
    }
    public void setRightIconVisibility(int visibility){
        if (mRightIconIV != null){
            mRightIconIV.setVisibility(visibility);
        }
    }
}
