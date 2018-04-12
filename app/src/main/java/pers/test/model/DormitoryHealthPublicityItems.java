package pers.test.model;

import java.io.Serializable;

/**
 * Created by Jaye Li on 2018/4/12.
 */

public class DormitoryHealthPublicityItems implements Serializable {

    private String name; // 寝室号/名
    private String manager; // 寝室管理员
    private float score; // 分数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
