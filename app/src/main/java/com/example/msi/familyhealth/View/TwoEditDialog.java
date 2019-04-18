package com.example.msi.familyhealth.View;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.msi.familyhealth.R;

public class TwoEditDialog extends Dialog {

    public TwoEditDialog(@NonNull Context context) {
        super(context);
    }


    public TwoEditDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    public TwoEditDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
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

        private TwoEditDialog twoEditDialog;

        public Builder(Context context) {
            twoEditDialog = new TwoEditDialog(context, R.style.Theme_AppCompat_Dialog);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //加载布局
            mLayout = inflater.inflate(R.layout.two_et_dialog, null, false);
            //添加布局到dialog
            twoEditDialog.addContentView(mLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            positiveButton = mLayout.findViewById(R.id.dialog_confirm_bt);
            negativeButton = mLayout.findViewById(R.id.dialog_cancel_bt);
            memberNameEt = mLayout.findViewById(R.id.dialog_et1);
            phoneEt = mLayout.findViewById(R.id.dialog_et2);
        }

        public Builder setEditText1(String meg) {
            memberNameEt.setHint(meg);
            return this;
        }


        public Builder setEditText2(String meg) {
            phoneEt.setHint(meg);
            return this;
        }

        public Builder setPositiveButton(String text, View.OnClickListener listener) {
            positiveButton.setText(text);
            positiveButton.setOnClickListener(listener);
            return this;
        }

        public Builder setNegativeButton(String text, View.OnClickListener listener) {
            negativeButton.setText(text);
            negativeButton.setOnClickListener(listener);
            return this;
        }

        public TwoEditDialog create() {
            positiveButton.setOnClickListener(view -> {
                twoEditDialog.dismiss();
                positiveButtonOnClickListener.onClick(view);
            });

            negativeButton.setOnClickListener(view -> {
                twoEditDialog.dismiss();
                negativeButtonOnClickListener.onClick(view);
            });

            twoEditDialog.setContentView(mLayout);
            twoEditDialog.setCancelable(true);//点击后退键关闭dialog
            twoEditDialog.setCanceledOnTouchOutside(false);//点击外部不可关闭
            return twoEditDialog;
        }
    }
}
