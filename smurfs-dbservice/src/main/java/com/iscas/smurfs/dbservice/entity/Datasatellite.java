package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

public class Datasatellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 卫星类别
     */
    @Column(name = "Category")
    private String category;

    /**
     * 卫星类型
     */
    @Column(name = "Type")
    private String type;

    /**
     * 服役年份
     */
    @Column(name = "YearCommissioned")
    private Integer yearcommissioned;

    /**
     * 长
     */
    @Column(name = "Length")
    private Double length;

    /**
     * 展开大小
     */
    @Column(name = "Span")
    private Double span;

    /**
     * 高
     */
    @Column(name = "Height")
    private Double height;

    /**
     * 空重
     */
    @Column(name = "WeightEmpty")
    private Integer weightempty;

    /**
     * 最大起飞重量
     */
    @Column(name = "WeightMax")
    private Integer weightmax;

    /**
     * 最大载重
     */
    @Column(name = "WeightPayload")
    private Integer weightpayload;

    /**
     * 装甲等级
     */
    @Column(name = "Armor")
    private Integer armor;

    /**
     * 抗毁点数
     */
    @Column(name = "DamagePoints")
    private Integer damagepoints;

    /**
     * 造价
     */
    @Column(name = "Cost")
    private Integer cost;

    /**
     * 所属经费
     */
    @Column(name = "fund_id")
    private String fundId;

    /**
     * 所属基地
     */
    @Column(name = "base_id")
    private String baseId;

    /**
     * 所属组织机构
     */
    @Column(name = "group_id")
    private String groupId;

    /**
     * 卫星名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取卫星类别
     *
     * @return Category - 卫星类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置卫星类别
     *
     * @param category 卫星类别
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取卫星类型
     *
     * @return Type - 卫星类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置卫星类型
     *
     * @param type 卫星类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取服役年份
     *
     * @return YearCommissioned - 服役年份
     */
    public Integer getYearcommissioned() {
        return yearcommissioned;
    }

    /**
     * 设置服役年份
     *
     * @param yearcommissioned 服役年份
     */
    public void setYearcommissioned(Integer yearcommissioned) {
        this.yearcommissioned = yearcommissioned;
    }

    /**
     * 获取长
     *
     * @return Length - 长
     */
    public Double getLength() {
        return length;
    }

    /**
     * 设置长
     *
     * @param length 长
     */
    public void setLength(Double length) {
        this.length = length;
    }

    /**
     * 获取展开大小
     *
     * @return Span - 展开大小
     */
    public Double getSpan() {
        return span;
    }

    /**
     * 设置展开大小
     *
     * @param span 展开大小
     */
    public void setSpan(Double span) {
        this.span = span;
    }

    /**
     * 获取高
     *
     * @return Height - 高
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置高
     *
     * @param height 高
     */
    public void setHeight(Double height) {
        this.height = height;
    }

    /**
     * 获取空重
     *
     * @return WeightEmpty - 空重
     */
    public Integer getWeightempty() {
        return weightempty;
    }

    /**
     * 设置空重
     *
     * @param weightempty 空重
     */
    public void setWeightempty(Integer weightempty) {
        this.weightempty = weightempty;
    }

    /**
     * 获取最大起飞重量
     *
     * @return WeightMax - 最大起飞重量
     */
    public Integer getWeightmax() {
        return weightmax;
    }

    /**
     * 设置最大起飞重量
     *
     * @param weightmax 最大起飞重量
     */
    public void setWeightmax(Integer weightmax) {
        this.weightmax = weightmax;
    }

    /**
     * 获取最大载重
     *
     * @return WeightPayload - 最大载重
     */
    public Integer getWeightpayload() {
        return weightpayload;
    }

    /**
     * 设置最大载重
     *
     * @param weightpayload 最大载重
     */
    public void setWeightpayload(Integer weightpayload) {
        this.weightpayload = weightpayload;
    }

    /**
     * 获取装甲等级
     *
     * @return Armor - 装甲等级
     */
    public Integer getArmor() {
        return armor;
    }

    /**
     * 设置装甲等级
     *
     * @param armor 装甲等级
     */
    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    /**
     * 获取抗毁点数
     *
     * @return DamagePoints - 抗毁点数
     */
    public Integer getDamagepoints() {
        return damagepoints;
    }

    /**
     * 设置抗毁点数
     *
     * @param damagepoints 抗毁点数
     */
    public void setDamagepoints(Integer damagepoints) {
        this.damagepoints = damagepoints;
    }

    /**
     * 获取造价
     *
     * @return Cost - 造价
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * 设置造价
     *
     * @param cost 造价
     */
    public void setCost(Integer cost) {
        this.cost = cost;
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
     * 获取所属组织机构
     *
     * @return group_id - 所属组织机构
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置所属组织机构
     *
     * @param groupId 所属组织机构
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取卫星名称
     *
     * @return Name - 卫星名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置卫星名称
     *
     * @param name 卫星名称
     */
    public void setName(String name) {
        this.name = name;
    }
}