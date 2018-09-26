package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

@Table(name = "t_fund")
public class Fund {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 经费名称
     */
    private String name;

    /**
     * 经费类别 0 军人福利 1 日常管理 2 作战费用 3 训练费用 4 维护费用 5 基础建设 6 后勤保障 7 技术创新
     */
    private String type;

    /**
     * 是否属于重点项目 0 是 1 不是
     */
    @Column(name = "is_vip")
    private String isVip;

    /**
     * 是否预算类 0 是 1 不是
     */
    @Column(name = "is_budget")
    private String isBudget;

    /**
     * 飞机
     */
    private String dataaircraft;

    /**
     * 卫星
     */
    private String datasatellite;

    /**
     * 设施
     */
    private String facility;

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
     * 获取经费名称
     *
     * @return name - 经费名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置经费名称
     *
     * @param name 经费名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取经费类别 0 军人福利 1 日常管理 2 作战费用 3 训练费用 4 维护费用 5 基础建设 6 后勤保障 7 技术创新
     *
     * @return type - 经费类别 0 军人福利 1 日常管理 2 作战费用 3 训练费用 4 维护费用 5 基础建设 6 后勤保障 7 技术创新
     */
    public String getType() {
        return type;
    }

    /**
     * 设置经费类别 0 军人福利 1 日常管理 2 作战费用 3 训练费用 4 维护费用 5 基础建设 6 后勤保障 7 技术创新
     *
     * @param type 经费类别 0 军人福利 1 日常管理 2 作战费用 3 训练费用 4 维护费用 5 基础建设 6 后勤保障 7 技术创新
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取是否属于重点项目 0 是 1 不是
     *
     * @return is_vip - 是否属于重点项目 0 是 1 不是
     */
    public String getIsVip() {
        return isVip;
    }

    /**
     * 设置是否属于重点项目 0 是 1 不是
     *
     * @param isVip 是否属于重点项目 0 是 1 不是
     */
    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    /**
     * 获取是否预算类 0 是 1 不是
     *
     * @return is_budget - 是否预算类 0 是 1 不是
     */
    public String getIsBudget() {
        return isBudget;
    }

    /**
     * 设置是否预算类 0 是 1 不是
     *
     * @param isBudget 是否预算类 0 是 1 不是
     */
    public void setIsBudget(String isBudget) {
        this.isBudget = isBudget;
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
     * 获取设施
     *
     * @return facility - 设施
     */
    public String getFacility() {
        return facility;
    }

    /**
     * 设置设施
     *
     * @param facility 设施
     */
    public void setFacility(String facility) {
        this.facility = facility;
    }
}