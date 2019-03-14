package com.example.msi.familyhealth.View;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.msi.familyhealth.R;

/**
 * 自定义标题栏，改变标题和两侧图标显示
 */
public class TitleView extends ConstraintLayout {
    private ImageButton backBt;
    private ImageButton confirmBt;
    private TextView titleTv;
    private TextView leftTv;
    private TextView rightTv;
    private ConstraintLayout titleLayout;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initView(context,attrs);
    }

    /**
     * @param context
     * @param attributeSet 初始化视图信息
     */
    private void initView(final Context context, AttributeSet attributeSet) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        titleLayout = inflate.findViewById(R.id.title_layout);
        backBt = inflate.findViewById(R.id.back_bt);
        confirmBt = inflate.findViewById(R.id.confirm_bt);
        titleTv = inflate.findViewById(R.id.title_tv);
        leftTv = inflate.findViewById(R.id.left_tv);
        rightTv = inflate.findViewById(R.id.right_tv);

        init(context, attributeSet);
    }

    /*
    titleLayout = inflate.findViewById(R.id.title_layout);
        backBt = inflate.findViewById(R.id.back_bt);
        confirmBt = inflate.findViewById(R.id.confirm_bt);
        titleTv = inflate.findViewById(R.id.titel_tv);
        leftTv = inflate.findViewById(R.id.left_tv);
        rightTv = inflate.findViewById(R.id.right_text);
       <attr name="background_color" format="integer"/>
        <attr name="title" format="string" />
        <attr name="title_size" format="integer" />
        <attr name="left_icon" format="reference" />
        <attr name="right_icon" format="reference" />
        <attr name="icon_weight" format="integer"/>
        <attr name="icon_height" format="integer"/>
        <attr name="left_text" format="string" />
        <attr name="right_text" format="string" />
        <attr name="text_size" format="integer" />
        <attr name="title_type" format="integer" />*/
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.TitleView);
        int backgoundColor = typedArray.getColor(R.styleable.TitleView_background_color,getResources().getColor(R.color.loginYellow));
        String title = typedArray.getString(R.styleable.TitleView_title);
        int titleSize = typedArray.getInt(R.styleable.TitleView_title_size, 24);
        int leftIcon = typedArray.getResourceId(R.styleable.TitleView_left_icon, 0);
        int rightIcon = typedArray.getResourceId(R.styleable.TitleView_right_icon, 0);
        int iconWidth = typedArray.getInt(R.styleable.TitleView_icon_width, 0);
        int iconHeight = typedArray.getInt(R.styleable.TitleView_icon_height, 56);
        String leftText = typedArray.getString(R.styleable.TitleView_left_text);
        String rightText = typedArray.getString(R.styleable.TitleView_right_text);
        int textSize = typedArray.getInt(R.styleable.TitleView_text_size, 20);
        int titleType = typedArray.getInt(R.styleable.TitleView_title_type, 0);

        //选择顶部导航栏的样式
        if (titleType == 0){
            backBt.setVisibility(View.VISIBLE);
            confirmBt.setVisibility(View.VISIBLE);
            leftTv.setVisibility(View.GONE);
            rightTv.setVisibility(View.GONE);
        }else if(titleType == 1){
            backBt.setVisibility(View.GONE);
            confirmBt.setVisibility(View.GONE);
            leftTv.setVisibility(View.VISIBLE);
            rightTv.setVisibility(View.VISIBLE);
        }else if (titleType == 2){
            backBt.setVisibility(View.GONE);
            confirmBt.setVisibility(View.GONE);
            leftTv.setVisibility(View.GONE);
            rightTv.setVisibility(View.GONE);
        }else if (titleType == 3){
            backBt.setVisibility(View.VISIBLE);
            confirmBt.setVisibility(View.GONE);
            leftTv.setVisibility(View.GONE);
            rightTv.setVisibility(View.VISIBLE);
        }

        //设置属性
        titleLayout.setBackgroundColor(backgoundColor);
        titleTv.setText(title);
        titleTv.setTextSize(titleSize);
        backBt.setBackgroundResource(leftIcon);
        confirmBt.setBackgroundResource(rightIcon);
        leftTv.setText(leftText);
        rightTv.setText(rightText);
        leftTv.setTextSize(textSize);
        rightTv.setTextSize(textSize);
    }

    /*给布局内控件设置点击事件*/
    public void setBackBtOnclickListener(OnClickListener onclickListener){
        backBt.setOnClickListener(onclickListener);
    }

    public void setConfirmBtOnclickListener(OnClickListener onclickListener){
        confirmBt.setOnClickListener(onclickListener);
    }

    public void setLeftTvOnclickListener(OnClickListener onclickListener){
        leftTv.setOnClickListener(onclickListener);
    }

    public void setRightTvOnclickListener(OnClickListener onclickListener){
        rightTv.setOnClickListener(onclickListener);
    }

}
