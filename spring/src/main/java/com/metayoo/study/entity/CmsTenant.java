package com.metayoo.study.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_tenant")
public class CmsTenant extends Model<CmsTenant> {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 租户ID
     */
    @TableField("tenant_id")
    private String tenantId;

    /**
     * 租户名称
     */
    @TableField("tenant_name")
    private String tenantName;

    /**
     * 租户描述
     */
    @TableField("tenant_desc")
    private String tenantDesc;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 更新时间
     */
    @TableField("gmt_modified")
    private Date gmtModified;

    /**
     * 创建时间
     */
    @TableField("gmt_created")
    private Date gmtCreated;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
