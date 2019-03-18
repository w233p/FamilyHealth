package com.example.msi.familyhealth.View;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msi.familyhealth.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>适应多布局的列表适配器
 */
public abstract class MainListAdapter<T> extends MyListViewAdapter {

    private static final int TYPE_ONE = 0;
    private static final int TYPE_TWO = 1;
    private List<String> list;
    private int type;

    /**
     * 测试数据
     */
    private void initList() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("测试" + i);
        }
    }

    public MainListAdapter(Context context, List list) {
        super(context, list);
    }

    /**
     * @param position 确定列表的样式，多布局的关键点
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        initList();
        if (list.get(position).equals("测试3")) {
            return TYPE_ONE;
        }
        return TYPE_TWO;
    }

    /**
     * 返回样式的总数
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 2;
    }

    /**
     * 根据type分配不同的布局，将需要的布局ID传给holder然后据此返回view。
     *
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        type = getItemViewType(position);
        int itemLayoutId;

        itemLayoutId = R.layout.list_item_text;
        switch (type) {
            case TYPE_ONE:
                itemLayoutId = R.layout.list_item_text;
                break;
            case TYPE_TWO:
                itemLayoutId = R.layout.list_item_text2;
                break;
        }

        ViewHolder viewHolder = getViewHolder(position, convertView, parent, itemLayoutId);

        convert(viewHolder, getItem(position));
        return viewHolder.getConvertView();
    }

    /**
     * @return 给外部公开type，方便赋值
     */
    public int getTpye() {
        return type;
    }
}
