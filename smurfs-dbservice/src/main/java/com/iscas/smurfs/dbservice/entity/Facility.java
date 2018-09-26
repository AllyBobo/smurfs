package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

@Table(name = "t_facility")
public class Facility {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 设施名称
     */
    private String name;

    /**
     * 0 能源类 1 交通类 2 基础建设类
     */
    private String type;

    /**
     * 用途
     */
    private String purpose;

    /**
     * 所属基地
     */
    @Column(name = "base_id")
    private String baseId;

    /**
     * 所属经费
     */
    @Column(name = "fund_id")
    private String fundId;

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
     * 获取设施名称
     *
     * @return name - 设施名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置设施名称
     *
     * @param name 设施名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取0 能源类 1 交通类 2 基础建设类
     *
     * @return type - 0 能源类 1 交通类 2 基础建设类
     */
    public String getType() {
        return type;
    }

    /**
     * 设置0 能源类 1 交通类 2 基础建设类
     *
     * @param type 0 能源类 1 交通类 2 基础建设类
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取用途
     *
     * @return purpose - 用途
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * 设置用途
     *
     * @param purpose 用途
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * 获取所属基地
     *
     * @return base_id - 所属基地
     */
    public String getBaseId() {
        return baseId;
    }

    /**
     * 设置所属基地
     *
     * @param baseId 所属基地
     */
    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    /**
     * 获取所属经费
     *
     * @return fund_id - 所属经费
     */
    public String getFundId() {
        return fundId;
    }

    /**
     * 设置所属经费
     *
     * @param fundId 所属经费
     */
    public void setFundId(String fundId) {
        this.fundId = fundId;
    }
}