package com.example.msi.familyhealth;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class TipDetailDialog extends Dialog {

    public TipDetailDialog(@NonNull Context context) {
        super(context);
    }

    public TipDetailDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public TipDetailDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public static class Builder {
        private View mLayout;

        private Button positiveButton;
        private Button negativeButton;
        private EditText memberNameEt;
        private EditText phoneEt;

        private View.OnClickListener positiveButtonOnClickListener;
        private View.OnClickListener negativeButtonOnClickListener;

        private TipDetailDialog TipDetailDialog;

        public String getMemberNameText() {
            return memberNameEt.getText().toString();
        }

        public String getPhoneText() {
            return phoneEt.getText().toString();
        }

        public Builder(Context context) {
            TipDetailDialog = new TipDetailDialog(context, R.style.Theme_AppCompat_Dialog);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //加载布局
            mLayout = inflater.inflate(R.layout., null, false);
            //添加布局到dialog
            TipDetailDialog.addContentView(mLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            positiveButton = mLayout.findViewById(R.id.dialog_confirm_bt);
            negativeButton = mLayout.findViewById(R.id.dialog_cancel_bt);
            memberNameEt = mLayout.findViewById(R.id.dialog_et1);
            phoneEt = mLayout.findViewById(R.id.dialog_et2);
        }

        public TipDetailDialog.Builder setEditText1(String meg) {
            memberNameEt.setHint(meg);
            return this;
        }

        public TipDetailDialog getThisDialog() {
            return TipDetailDialog;
        }


        public TipDetailDialog.Builder setEditText2(String meg) {
            phoneEt.setHint(meg);
            return this;
        }

        public TipDetailDialog.Builder setPositiveButton(String text, View.OnClickListener listener) {
            positiveButton.setText(text);
            positiveButton.setOnClickListener(listener);
            this.positiveButtonOnClickListener = listener;
            return this;
        }

        public TipDetailDialog.Builder setNegativeButton(String text, View.OnClickListener listener) {
            negativeButton.setText(text);
            negativeButton.setOnClickListener(listener);
            this.negativeButtonOnClickListener = listener;
            return this;
        }

        public TipDetailDialog create() {
            positiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TipDetailDialog.dismiss();
                    positiveButtonOnClickListener.onClick(v);
                }
            });

            //   ->lambda表达式,就是匿名函数，这里试一下
            negativeButton.setOnClickListener(v -> {
                TipDetailDialog.dismiss();
                negativeButtonOnClickListener.onClick(v);
            });

            TipDetailDialog.setContentView(mLayout);
            TipDetailDialog.setCancelable(true);//点击后退键关闭dialog
            TipDetailDialog.setCanceledOnTouchOutside(false);//点击外部不可关闭
            return TipDetailDialog;
        }
    }
}
