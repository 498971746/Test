package com.jdy.application.adapter;

import android.content.Context;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jdy.application.R;
import com.jdy.application.bean.CommentItemList;
import com.jdy.application.bean.ReplyImage;
import com.jdy.application.bean.ReplyItemList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Dale on 2017/8/21.
 */

public class ParentAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<ReplyItemList> list;

    public ParentAdapter(Context context, List<ReplyItemList> list) {
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

    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = views.get(position);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_main_item, null);
            ReplyItem replyItem = getReplyItem(convertView);

            setReplyItem(context, replyItem, list.get(position));

            views.put(position, convertView);
        }
        return convertView;
    }

    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    private void setReplyItem(Context context, ReplyItem replyItem, ReplyItemList itemList) {
        Glide.with(context).load(itemList.getUserImage()).into(replyItem.list_reply_item_user_image);

        if (itemList.getMale())
            replyItem.list_reply_item_user_sex.setImageResource(R.drawable.contact_male);
        else replyItem.list_reply_item_user_sex.setImageResource(R.drawable.contact_female);

        replyItem.list_reply_item_user_name.setText(itemList.getUserName());

        if (itemList.getVip())
            replyItem.list_reply_item_user_vip.setVisibility(View.VISIBLE);
        else replyItem.list_reply_item_user_vip.setVisibility(View.INVISIBLE);

        replyItem.list_reply_item_user_game_name.setText(itemList.getGameName());
        replyItem.list_reply_item_user_game_area.setText(itemList.getGameArea());
        replyItem.list_reply_item_user_game_segment.setText(itemList.getGameSegment());

        setReplyContent(context, replyItem, itemList.getReplyContent(), itemList.getReplyImage());

        replyItem.list_main_item_content_time.setText(itemList.getTime());
        replyItem.list_main_item_content_from.setText(itemList.getFrom());

        setComment(context, replyItem, itemList.getCommentNumber(), itemList.getCommentItemList());

        setPraise(context, replyItem, itemList.getPraiseNumber(), itemList.getUserList());
    }

    private void setComment(Context context, ReplyItem replyItem, int commentNumber, List<CommentItemList> commentItemList) {
        replyItem.list_main_item_content_comment_count.setText(String.valueOf(commentNumber));

        if (commentNumber == 0) {
            replyItem.list_main_item_comment_list_view.setVisibility(View.GONE);
        } else {
            int length;

            if (commentNumber > 10) {
                length = 10;
                LinearLayout endView = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.list_child_item_bottom, null);
                replyItem.list_main_item_comment_list_view.addFooterView(endView);
            } else length = commentNumber;

            List<CommentItemList> comments = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                comments.add(commentItemList.get(i));
            }

            replyItem.list_main_item_comment_list_view.setVisibility(View.VISIBLE);
            replyItem.list_main_item_comment_list_view.setAdapter(new ChildAdapter(context, comments));
        }
    }

    /**
     * replyContent和replyImage不能都为空，若都为空则直接跳出此方法
     * @param context  上下文
     * @param replyItem item控件类
     * @param replyContent  为空则不显示，否则显示
     * @param replyImage 为空则不显示； 否则显示
     */
    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    private void setReplyContent(Context context, ReplyItem replyItem, String replyContent, List<ReplyImage> replyImage) {
        if (replyContent != null || replyImage != null) {

            if (replyContent != null) {
                replyItem.list_main_item__content_replay_content.setText(replyContent);
                replyItem.list_main_item__content_replay_content.setVisibility(View.VISIBLE);
            } else replyItem.list_main_item__content_replay_content.setVisibility(View.GONE);

            if (replyImage != null) {

                int imageSize = replyImage.size(); //获取图片的数量

                if (imageSize == 1) { //图片数量为1，显示在ImageView中；GridLayout隐藏
                    Glide.with(context).load(replyImage.get(0).getContentImage()).into(replyItem.list_main_item_content_replay_image);
                    replyItem.list_main_item_content_replay_image.setVisibility(View.VISIBLE);
                    replyItem.list_main_item__content_replay_image_more.setVisibility(View.GONE);
                } else { //图片数量大于1，显示在GridLayout的新建子控件ImageView中；ImageView隐藏
                    replyItem.list_main_item_content_replay_image.setVisibility(View.GONE);
                    replyItem.list_main_item__content_replay_image_more.setVisibility(View.VISIBLE);

                    if (imageSize > 9) { //图片数量大于9张，则将前8张显示；最后一张用省略图替代
                        for (int i = 0; i < 8; i++) {
                            //向GridLayout中动态添加新建ImageView控件
                            replyItem.list_main_item__content_replay_image_more.addView(getImageView(i, 3, replyImage.get(i).getContentImage()));
                        }
                        replyItem.list_main_item__content_replay_image_more.addView(getImageView(8, 3, String.valueOf(R.drawable.ic_app_more)));
                    } else { //图片数量小于9张，依次显示在GridLayout中
                        for (int i = 0; i < imageSize; i++) {
                            replyItem.list_main_item__content_replay_image_more.addView(getImageView(i, 3, replyImage.get(i).getContentImage()));
                        }
                    }
                }
            } else { //图片集合为空，将显示图片的控件隐藏
                replyItem.list_main_item_content_replay_image.setVisibility(View.GONE);
                replyItem.list_main_item__content_replay_image_more.setVisibility(View.GONE);
            }
        } else return;
    }

    /**
     * @param position 图片在集合中的位置
     * @param root 显示图片的root，表示root行和root列
     * @param url 图片的URL地址
     * @return 返回ImageView的对象
     */
    @RequiresApi(api = VERSION_CODES.LOLLIPOP)
    private ImageView getImageView(int position, int root, String url) {

        GridLayout.Spec rowSpec = GridLayout.spec(position / root, 1f);
        GridLayout.Spec columnSpec = GridLayout.spec(position % root, 1f);

        // 定义一个GridLayout的子控件，设置子控件的height、width和margin
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(rowSpec, columnSpec);
        params.height = 260;
        params.width = 260;
        params.setMargins(2, 2, 2, 2);

        ImageView imageView = new ImageView(context); //定义一个ImageView控件
        imageView.setScaleType(ScaleType.CENTER_CROP); //设置图片填充方式为center_crop
        imageView.setLayoutParams(params); //设置ImageView含有GridLayout子控件的宽高属性
        Glide.with(context).load(url).into(imageView); //向ImageView中加载图片

        return imageView;
    }

    private void setPraise(Context context, ReplyItem replyItem, int praiseNumber, List<String> userList) {
        replyItem.list_main_item_content_praise_count.setText(String.valueOf(praiseNumber));

        if (praiseNumber == 0) {
            replyItem.list_main_item_content_praise_users.setVisibility(View.GONE);
        } else {
            replyItem.list_main_item_content_praise_users.setVisibility(View.VISIBLE);

            StringBuffer users = new StringBuffer();
            for (int i = 0; i < praiseNumber; i++) {
                users.append(userList.get(i) + "、");
            }

            String praiseUsers = users.substring(0, users.lastIndexOf("、")).toString();

            replyItem.list_main_item_content_praise_users.setMovementMethod(LinkMovementMethod.getInstance());
            replyItem.list_main_item_content_praise_users.setText(addClickablePart(context, praiseUsers), BufferType.SPANNABLE);
        }
    }

    private SpannableStringBuilder addClickablePart(final Context context, String userLikes) {
        ImageSpan span = new ImageSpan(context, R.drawable.feed_like_icon_smoba);
        SpannableString spanStr = new SpannableString("p.");
        spanStr.setSpan(span, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        SpannableStringBuilder ssb = new SpannableStringBuilder(spanStr);
        ssb.append(userLikes);

        String[] likeUsers = userLikes.split("、");

        for (int i = 0; i < likeUsers.length; i++) {
            final String name = likeUsers[i];
            final int start = userLikes.indexOf(name) + spanStr.length();

            ssb.setSpan(new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    Toast.makeText(context, name,
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setColor(context.getResources().getColor(R.color.list_main_item_content_like_text));
                    ds.setUnderlineText(false);
                }
            }, start, start + name.length(), 0);
        }

        return ssb.append(" 等" + likeUsers.length + "人觉得很赞");
    }

    private ReplyItem getReplyItem(View convertView) {
        ReplyItem replyItem = new ReplyItem();

        replyItem.list_reply_item_user_image = (CircleImageView) convertView.findViewById(R.id.list_reply_item_user_image);
        replyItem.list_reply_item_user_sex = (ImageView) convertView.findViewById(R.id.list_reply_item_user_sex);
        replyItem.list_reply_item_user_name = (TextView) convertView.findViewById(R.id.list_reply_item_user_name);
        replyItem.list_reply_item_user_vip = (ImageView) convertView.findViewById(R.id.list_reply_item_user_vip);
        replyItem.list_reply_item_user_game_name = (TextView) convertView.findViewById(R.id.list_reply_item_user_game_name);
        replyItem.list_reply_item_user_game_area = (TextView) convertView.findViewById(R.id.list_reply_item_user_game_area);
        replyItem.list_reply_item_user_game_segment = (TextView) convertView.findViewById(R.id.list_reply_item_user_game_segment);

        replyItem.list_main_item__content_replay_content = (TextView) convertView.findViewById(R.id.list_main_item__content_replay_content);
        replyItem.list_main_item__content_replay_image_more = (GridLayout) convertView.findViewById(R.id.list_main_item__content_replay_image_more);
        replyItem.list_main_item_content_replay_image = (ImageView) convertView.findViewById(R.id.list_main_item_content_replay_image);

        replyItem.list_main_item_content_time = (TextView) convertView.findViewById(R.id.list_main_item_content_time);
        replyItem.list_main_item_content_from = (TextView) convertView.findViewById(R.id.list_main_item_content_from);
        replyItem.list_main_item_content_make_comment = (ImageButton) convertView.findViewById(R.id.list_main_item_content_make_comment);
        replyItem.list_main_item_content_comment_count = (TextView) convertView.findViewById(R.id.list_main_item_content_comment_count);
        replyItem.list_main_item_content_make_praise = (ImageButton) convertView.findViewById(R.id.list_main_item_content_make_praise);
        replyItem.list_main_item_content_praise_count = (TextView) convertView.findViewById(R.id.list_main_item_content_praise_count);
        replyItem.list_main_item_content_praise_users = (TextView) convertView.findViewById(R.id.list_main_item_content_praise_users);

        replyItem.list_main_item_comment_list_view = (ListView) convertView.findViewById(R.id.list_main_item_comment_list_view);

        return replyItem;
    }

    private class ReplyItem {
        CircleImageView list_reply_item_user_image = null;
        ImageView list_reply_item_user_sex = null;
        TextView list_reply_item_user_name = null;
        ImageView list_reply_item_user_vip = null;
        TextView list_reply_item_user_game_name = null;
        TextView list_reply_item_user_game_area = null;
        TextView list_reply_item_user_game_segment = null;

        TextView list_main_item__content_replay_content = null;
        GridLayout list_main_item__content_replay_image_more = null;
        ImageView list_main_item_content_replay_image = null;

        TextView list_main_item_content_time = null;
        TextView list_main_item_content_from = null;

        ImageButton list_main_item_content_make_comment = null;
        TextView list_main_item_content_comment_count = null;
        ListView list_main_item_comment_list_view = null;

        ImageButton list_main_item_content_make_praise = null;
        TextView list_main_item_content_praise_count = null;
        TextView list_main_item_content_praise_users = null;
    }
}
