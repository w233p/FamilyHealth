package com.example.msi.familyhealth.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.msi.familyhealth.R;

import java.util.List;

/**
 * 列表适配器
 * 泛型增加其灵活性
 */
public abstract class HealthTipListViewAdapter<T> extends MyListViewAdapter {

    private int itemLayoutId;

    public HealthTipListViewAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemLayoutId = R.layout.list_item_health;
        ViewHolder holder = getViewHolder(position, convertView, parent, itemLayoutId);

        convert(holder, getItem(position));
        return holder.getConvertView();
    }
}
