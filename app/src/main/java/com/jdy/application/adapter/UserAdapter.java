package com.jdy.application.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Dale on 2017/8/28.
 */

public class UserAdapter extends BaseAdapter{


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    private class UserView {
        ImageView content_top_user_background_image = null;
        TextView content_top_user_name = null;
        TextView content_top_user_game_name = null;
        TextView content_top_user_game_area = null;
        TextView content_top_user_game_segment = null;
        CircleImageView content_top_user_image = null;
        ListView activity_main_content_list_view_main = null;
    }
}
