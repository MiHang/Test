package pers.test.model;

/**
 * Created by 丿丶祥灬少 on 2018/4/16.
 */

public class Dormitory_all {
    /*
    * 主要事件标题*/
   private String title_name;
   /*
   * 版块类型*/
   private String title_type;
   /*
   * 主要人物事件*/
   private String main_character;
   /*
   * 发生时间*/
   private String time;
   /*
   * 寝室号*/
   private String dormitory_number;
   /*
   * 具体内容描述*/
   private String Context;

    public String getTitle_name() {
        return title_name;
    }

    public void setTitle_name(String title_name) {
        this.title_name = title_name;
    }

    public String getTitle_type() {
        return title_type;
    }

    public void setTitle_type(String title_type) {
        this.title_type = title_type;
    }

    public String getMain_character() {
        return main_character;
    }

    public void setMain_character(String main_character) {
        this.main_character = main_character;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDormitory_number() {
        return dormitory_number;
    }

    public void setDormitory_number(String dormitory_number) {
        this.dormitory_number = dormitory_number;
    }

    public String getContext() {
        return Context;
    }

    public void setContext(String context) {
        Context = context;
    }
}
