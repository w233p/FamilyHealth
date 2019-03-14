package com.example.msi.familyhealth.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 列表适配器
 * 泛型增加其灵活性
 */
public abstract class MyListViewAdapter<T> extends BaseAdapter {

    private Context context;
    private List<String> list;
    private LayoutInflater inflater;
    private int itemLayoutId;

    public MyListViewAdapter(Context context,List<String> list, int itemLayoutId) {
        this.context = context;
        this.list = list;
        this.itemLayoutId = itemLayoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = getViewHolder(position, convertView, parent);

        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder viewHolder, String item);

    private ViewHolder getViewHolder(int position, View convertView, ViewGroup parent) {
        return ViewHolder.get(context, convertView, parent, itemLayoutId, position);
    }
}
