package com.jdy.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jdy.application.R;
import com.jdy.application.bean.CommentItemList;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Dale on 2017/8/21.
 */

public class ChildAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<CommentItemList> list;

    public ChildAdapter(Context context, List<CommentItemList> list) {
        this.context = context;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private HashMap<Integer, View> views = new HashMap<>();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = views.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_comment_item, null);
            CommentItem commentItem = new CommentItem();

            commentItem.commenter = (TextView) convertView.findViewById(R.id.list_comment_item_user);
            commentItem.content = (TextView) convertView.findViewById(R.id.list_comment_item_content);

            CommentItemList itemList = list.get(position);

            if (itemList.getFemale()) {
                commentItem.commenter.setTextColor(context.getResources().getColor(R.color.list_comment_item_female_user_name));
            } else commentItem.commenter.setTextColor(context.getResources().getColor(R.color.list_comment_item_male_user_name));

            commentItem.commenter.setText(itemList.getUserName());
            commentItem.content.setText(" : " + itemList.getContent());

            views.put(position, convertView);
        }
        return convertView;
    }

    private class CommentItem {
        TextView commenter = null;
        TextView content = null;
    }
}
