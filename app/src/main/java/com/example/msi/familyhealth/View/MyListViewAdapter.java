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
public abstract class MyListViewAdapter<T> extends BaseAdapter {

    private Context context;
    private List<String> textList;
    private LayoutInflater inflater;
    private int itemLayoutId;

    public MyListViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.textList = list;
        this.itemLayoutId = itemLayoutId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return textList == null ? 0 : textList.size();
    }

    @Override
    public String getItem(int position) {
        return textList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        itemLayoutId = R.layout.list_item_text;
        ViewHolder holder = getViewHolder(position, convertView, parent, itemLayoutId);

        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder viewHolder, String item);

    public ViewHolder getViewHolder(int position, View convertView, ViewGroup parent, int itemLayoutId) {
        return ViewHolder.get(context, convertView, parent, itemLayoutId, position);
    }
}
