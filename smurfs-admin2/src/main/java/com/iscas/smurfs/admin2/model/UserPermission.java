package com.iscas.smurfs.admin2.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yux
 * @since 2018-11-05
 */
@TableName("t_user_permission")
public class UserPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer userid;

    private Long permissionid;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Long getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }

    @Override
    public String toString() {
        return "UserPermission{" +
        ", id=" + id +
        ", userid=" + userid +
        ", permissionid=" + permissionid +
        "}";
    }
}
