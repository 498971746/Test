package com.jdy.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.jdy.application.adapter.ParentAdapter;
import com.jdy.application.bean.UserBean;
import com.jdy.application.utils.HttpURL;
import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;


public class Activity_Main extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getHttp();

        findViewById(R.id.float_button).setOnClickListener(this);
    }

    private void getHttp() {
        RxVolley.get(HttpURL.COMMENT_URL, new HttpCallback() {
            @Override
            public void onSuccess(String json) {
                setListView(new Gson().fromJson(json, UserBean.class));
            }
        });
    }

    private void setListView(UserBean user) {
        ListView listView = (ListView) findViewById(R.id.activity_main_content_list_view_main);
        listView.addHeaderView(getTopView(user));
        ParentAdapter adapter = new ParentAdapter(this, user.getReplyItemList());
        listView.setAdapter(adapter);
    }

    private LinearLayout getTopView(UserBean user) {
        LinearLayout topView = (LinearLayout) View.inflate(Activity_Main.this, R.layout.content_top, null);
        Glide.with(this).load(user.getBgImage()).into((ImageView) topView.findViewById(R.id.content_top_user_background_image));
        ((TextView) topView.findViewById(R.id.content_top_user_name)).setText(user.getUserName());
        ((TextView) topView.findViewById(R.id.content_top_user_game_name)).setText(user.getGameName());
        ((TextView) topView.findViewById(R.id.content_top_user_game_area)).setText(user.getGameArea());
        ((TextView) topView.findViewById(R.id.content_top_user_game_segment)).setText(user.getGameSegment());
        Glide.with(this).load(user.getUserImage()).into((ImageView) topView.findViewById(R.id.content_top_user_image));

        return topView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.float_button:
                startActivity(new Intent(".."));
                break;

            default:
                break;
        }
    }
}
