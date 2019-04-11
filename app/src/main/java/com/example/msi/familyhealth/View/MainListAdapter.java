package com.example.msi.familyhealth.View;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.msi.familyhealth.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @param <T>适应多布局的列表适配器
 */
public abstract class MainListAdapter<T> extends MyListViewAdapter {

    private static final int TYPE_ONE = 0;//闹钟
    private static final int TYPE_TWO = 1;//事件
    private static final int TYPE_THRRY = 2;//editText
    private List<String> list;
    private int type;
    private Context context;
    private LayoutInflater inflater;
    private int itemLayoutId;

    public MainListAdapter(Context context, List list) {
        super(context, list);
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    /**
     * @param position 确定列表的样式，多布局的关键点
     * @return
     */
    @Override
    public int getItemViewType(int position) {
//0is med,   1 is event
        if (list.get(position).equals("0")) {
            return TYPE_ONE;
        } else if (list.get(position).equals("1")) {
            return TYPE_TWO;
        } else {
            return TYPE_THRRY;
        }
        /**
         if (list.get(position).equals("成员") || list.get(position).equals("项目"))
         {
         return TYPE_ONE;
         }
         else
         {
         return TYPE_TWO;
         }
         */
    }

    /**
     * 返回样式的总数
     *
     * @return
     */
    @Override
    public int getViewTypeCount() {
        return 3;
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

        itemLayoutId = R.layout.list_item_edit;
        switch (type) {
            case TYPE_ONE:
                itemLayoutId = R.layout.list_clock_med;
                break;
            case TYPE_TWO:
                itemLayoutId = R.layout.list_clock_event;
                break;
            case TYPE_THRRY:
                itemLayoutId = R.layout.list_item_edit;
                break;
        }

        ViewHolder viewHolder = getViewHolder(position, convertView, parent, itemLayoutId);

        //药品提醒添加按钮
        if (itemLayoutId == R.layout.list_clock_med) {
            viewHolder.setButton();
        } else if (itemLayoutId == R.layout.list_item_edit) {
            viewHolder.setEditText();
        }

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
