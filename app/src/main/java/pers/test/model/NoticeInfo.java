package pers.test.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Jaye Li on 2018/4/2.
 */

public class NoticeInfo implements Serializable {

    private String content;
    private String picture;
    private String releaseTime;
    private String resource;
    private String title;
    private int viewTimes;

    public String toString() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("content",content);
            jsonObject.put("picture",picture);
            jsonObject.put("releaseTime",releaseTime);
            jsonObject.put("resource",resource);
            jsonObject.put("title",title);
            jsonObject.put("viewTimes",viewTimes);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViewTimes() {
        return viewTimes;
    }

    public void setViewTimes(int viewTimes) {
        this.viewTimes = viewTimes;
    }
}
