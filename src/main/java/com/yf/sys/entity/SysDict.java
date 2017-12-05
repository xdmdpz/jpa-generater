package com.yf.sys.entity;


import com.yf.core.base.BaseEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sys_dict", schema = "packageManage")
public class SysDict extends BaseEntity<String> implements Serializable {
    //数据值
    private String value;
    //标签名
    private String key;
    //类型
    private String type;
    //描述
    private String description;
    //排序（升序）
    private Double sort;

    public SysDict() {
        super();
    }

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "sys_dict_id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return this.value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "key")
    public String getKey() {
        return this.key;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return this.type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return this.description;
    }

    public void setSort(Double sort) {
        this.sort = sort;
    }

    @Basic
    @Column(name = "sort")
    public Double getSort() {
        return this.sort;
    }


}