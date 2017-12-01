package com.yf.common.base;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by if on 2017/12/1.
 */
@MappedSuperclass
public abstract class BaseTreeEntity<T ,ID extends Serializable> extends BaseEntity<ID> implements Serializable {
    //使用时需要在实体类pid字段做关联
    //重写get方法 指向pid字段
    @Transient
    protected ID pid;
    @Transient
    protected ID tid;

    @Transient
    protected List<T> clildren;


    public ID getPid() {
        return pid;
    }
    public void setPid(ID pid) {
        this.pid = pid;
    }

    public List<T> getClildren() {
        return clildren;
    }

    public void setClildren(List<T> clildren) {
        this.clildren = clildren;
    }

    public ID getTid() {
        return tid;
    }

    public void setTid(ID tid) {
        this.tid = tid;
    }
}
