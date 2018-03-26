package pers.test.model;

import java.util.logging.SimpleFormatter;

/**
* 用于存储item数据
*/
public class NewsItemData extends SimpleFormatter {

    private String title; // 标题
    private String time; // 时间
    private String commentNum; // 评论数
    private String publishTime; // 发布时间
    private int Icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(String commentNum) {
        this.commentNum = commentNum;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public int getIcon() {
        return Icon;
    }

    public void setIcon(int icon) {
        Icon = icon;
    }
}
