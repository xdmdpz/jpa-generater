package com.yf.core.entity;

import com.yf.core.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project_info", schema = "generater")
public class ProjectInfo extends BaseEntity<String> implements Serializable {
    //项目名称
    private String project_name;
    //项目描述
    private String project_desc;

    public ProjectInfo() {
        super();
    }

    @Id
    @Column(name = "project_info_id", nullable = false, length = 32)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return this.project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_desc() {
        return this.project_desc;
    }

    public void setProject_desc(String project_desc) {
        this.project_desc = project_desc;
    }


}