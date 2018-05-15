package com.xsh.activity.module.act.entity;

/**
 * @author by@Deng
 * @create 2018-05-15 23:45
 */
public class GroupActEntity {

    private Integer id;
    private Integer actId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    @Override
    public String toString() {
        return "GroupActEntity{" +
                "id=" + id +
                ", actId=" + actId +
                '}';
    }
}
