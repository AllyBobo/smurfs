package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

@Table(name = "t_group")
public class Group {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 部队名称
     */
    private String name;

    /**
     * 父级部队编号
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 总人数
     */
    @Column(name = "user_num")
    private Integer userNum;

    /**
     * 年经费预算（万）
     */
    private Integer bugdet;

    /**
     * 武器装备
     */
    private String equip;

    /**
     * 基地编号
     */
    @Column(name = "base_id")
    private String baseId;

    /**
     * 飞机
     */
    private String dataaircraft;

    /**
     * 卫星
     */
    private String datasatellite;

    /**
     * 人员
     */
    private String user;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取部队名称
     *
     * @return name - 部队名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置部队名称
     *
     * @param name 部队名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取父级部队编号
     *
     * @return parent_id - 父级部队编号
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * 设置父级部队编号
     *
     * @param parentId 父级部队编号
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取总人数
     *
     * @return user_num - 总人数
     */
    public Integer getUserNum() {
        return userNum;
    }

    /**
     * 设置总人数
     *
     * @param userNum 总人数
     */
    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    /**
     * 获取年经费预算（万）
     *
     * @return bugdet - 年经费预算（万）
     */
    public Integer getBugdet() {
        return bugdet;
    }

    /**
     * 设置年经费预算（万）
     *
     * @param bugdet 年经费预算（万）
     */
    public void setBugdet(Integer bugdet) {
        this.bugdet = bugdet;
    }

    /**
     * 获取武器装备
     *
     * @return equip - 武器装备
     */
    public String getEquip() {
        return equip;
    }

    /**
     * 设置武器装备
     *
     * @param equip 武器装备
     */
    public void setEquip(String equip) {
        this.equip = equip;
    }

    /**
     * 获取基地编号
     *
     * @return base_id - 基地编号
     */
    public String getBaseId() {
        return baseId;
    }

    /**
     * 设置基地编号
     *
     * @param baseId 基地编号
     */
    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    /**
     * 获取飞机
     *
     * @return dataaircraft - 飞机
     */
    public String getDataaircraft() {
        return dataaircraft;
    }

    /**
     * 设置飞机
     *
     * @param dataaircraft 飞机
     */
    public void setDataaircraft(String dataaircraft) {
        this.dataaircraft = dataaircraft;
    }

    /**
     * 获取卫星
     *
     * @return datasatellite - 卫星
     */
    public String getDatasatellite() {
        return datasatellite;
    }

    /**
     * 设置卫星
     *
     * @param datasatellite 卫星
     */
    public void setDatasatellite(String datasatellite) {
        this.datasatellite = datasatellite;
    }

    /**
     * 获取人员
     *
     * @return user - 人员
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置人员
     *
     * @param user 人员
     */
    public void setUser(String user) {
        this.user = user;
    }
}