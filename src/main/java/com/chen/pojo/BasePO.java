package com.chen.pojo;

import java.util.Date;

/**
 * @description 基础po
 *
 * @date 2022/04/09
 */
public class BasePO {

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 删除状态
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BasePO{" +
                "id=" + id +
                ", createdTime=" + createdTime +
                ", modifyTime=" + modifyTime +
                ", status=" + status +
                '}';
    }
}
