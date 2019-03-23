package com.example.msi.familyhealth.View;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.msi.familyhealth.Login.LoginActivity;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComModel;
import com.example.msi.familyhealth.MyData.DataFragment.FragmentComPresenter;
import com.example.msi.familyhealth.MyData.DataFragment.Fragment_commen;
import com.example.msi.familyhealth.MyData.MyDataActivity;
import com.example.msi.familyhealth.MyData.MyDataContacts;
import com.example.msi.familyhealth.R;

import java.util.List;

/**
 * 适配器的ViewHolder
 */
public class ViewHolder {
    private final SparseArray<View> views;
    private View convertView;
    private Context context;
    private EditText editText;
    private int positon;

    public ViewHolder(Context context, ViewGroup parent, int itemLayoutId, int position) {
        this.context = context;
        this.views = new SparseArray<>();
        this.convertView = LayoutInflater.from(context).inflate(itemLayoutId, parent, false);
        this.positon = position;
        convertView.setTag(this);
    }

    /**
     * 获取ViewHolder对象
     */
    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    /**
     * @param viewId 通过ID获取控件，如果没有就添加一个
     */
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return convertView;
    }

    /**
     * @param viewId
     * @param text   设置文字
     */
    public ViewHolder setText(int viewId, String text) {
        TextView textView = getView(viewId);
        textView.setText(text);
        return this;
    }

    /**
     * @param viewId
     * @param drawableId 设置图片
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(drawableId);
        return this;
    }

    public void setEditText() {
        editText = getView(R.id.list_edit);
        editText.setTag(positon);
        editText.addTextChangedListener(new TextSwitcher(this) {
        });
    }

    public EditText getEditText() {
        return this.editText;
    }


    class TextSwitcher implements TextWatcher {
        private ViewHolder viewHolder;

        public TextSwitcher(ViewHolder viewHolder) {
            this.viewHolder = viewHolder;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            int position = (int) viewHolder.getEditText().getTag();

            ((MyDataActivity)context).getEditText(position, s.toString());
            Log.e("after", "run");
        }
    }


}
