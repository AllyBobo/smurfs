package com.iscas.smurfs.core.admin.entity.po;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "t_user_permission")
public class UserPermission  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer userid;

    private Long permissionid;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return userid
     */
    public Integer getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * @return permissionid
     */
    public Long getPermissionid() {
        return permissionid;
    }

    /**
     * @param permissionid
     */
    public void setPermissionid(Long permissionid) {
        this.permissionid = permissionid;
    }
}