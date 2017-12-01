package com.yf.core.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by if on 2017/11/22.
 */
@MappedSuperclass
public abstract class BaseEntity<ID extends Serializable> implements Serializable{
    protected ID id;
    protected Date createTime;
    protected Date updateTime;
    protected String delTag = "0";


    @Column(name = "create_time", nullable = false)
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Column(name = "update_time", nullable = true)
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }


    @Column(name = "del_tag", nullable = false, length = 1)
    public String getDelTag() {
        return delTag;
    }

    public void setDelTag(String delTag) {
        this.delTag = delTag;
    }



}
