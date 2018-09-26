package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

public class Dataaircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 飞机类别
     */
    @Column(name = "Category")
    private String category;

    /**
     * 飞机类型
     */
    @Column(name = "Type")
    private String type;

    /**
     * 服役年份
     */
    @Column(name = "YearCommissioned")
    private Integer yearcommissioned;

    /**
     * 机长
     */
    @Column(name = "Length")
    private Double length;

    /**
     * 翼展
     */
    @Column(name = "Span")
    private Double span;

    /**
     * 机高
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
     * 机组人员人数
     */
    @Column(name = "Crew")
    private Integer crew;

    /**
     * 机动力指数
     */
    @Column(name = "Agility")
    private Double agility;

    /**
     * 爬升率
     */
    @Column(name = "ClimbRate")
    private Double climbrate;

    /**
     * 飞机总耐久
     */
    @Column(name = "TotalEndurance")
    private Integer totalendurance;

    /**
     * 飞机采购单价
     */
    @Column(name = "Cost")
    private Integer cost;

    /**
     * 飞机抗伤害的总点数
     */
    @Column(name = "DamagePoints")
    private Integer damagepoints;

    /**
     * 受油速度
     */
    @Column(name = "FuelOffloadRate")
    private Integer fueloffloadrate;

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
     * 飞机名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 可见性
     */
    @Column(name = "Visibility")
    private String visibility;

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
     * 获取飞机类别
     *
     * @return Category - 飞机类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置飞机类别
     *
     * @param category 飞机类别
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取飞机类型
     *
     * @return Type - 飞机类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置飞机类型
     *
     * @param type 飞机类型
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
     * 获取机长
     *
     * @return Length - 机长
     */
    public Double getLength() {
        return length;
    }

    /**
     * 设置机长
     *
     * @param length 机长
     */
    public void setLength(Double length) {
        this.length = length;
    }

    /**
     * 获取翼展
     *
     * @return Span - 翼展
     */
    public Double getSpan() {
        return span;
    }

    /**
     * 设置翼展
     *
     * @param span 翼展
     */
    public void setSpan(Double span) {
        this.span = span;
    }

    /**
     * 获取机高
     *
     * @return Height - 机高
     */
    public Double getHeight() {
        return height;
    }

    /**
     * 设置机高
     *
     * @param height 机高
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
     * 获取机组人员人数
     *
     * @return Crew - 机组人员人数
     */
    public Integer getCrew() {
        return crew;
    }

    /**
     * 设置机组人员人数
     *
     * @param crew 机组人员人数
     */
    public void setCrew(Integer crew) {
        this.crew = crew;
    }

    /**
     * 获取机动力指数
     *
     * @return Agility - 机动力指数
     */
    public Double getAgility() {
        return agility;
    }

    /**
     * 设置机动力指数
     *
     * @param agility 机动力指数
     */
    public void setAgility(Double agility) {
        this.agility = agility;
    }

    /**
     * 获取爬升率
     *
     * @return ClimbRate - 爬升率
     */
    public Double getClimbrate() {
        return climbrate;
    }

    /**
     * 设置爬升率
     *
     * @param climbrate 爬升率
     */
    public void setClimbrate(Double climbrate) {
        this.climbrate = climbrate;
    }

    /**
     * 获取飞机总耐久
     *
     * @return TotalEndurance - 飞机总耐久
     */
    public Integer getTotalendurance() {
        return totalendurance;
    }

    /**
     * 设置飞机总耐久
     *
     * @param totalendurance 飞机总耐久
     */
    public void setTotalendurance(Integer totalendurance) {
        this.totalendurance = totalendurance;
    }

    /**
     * 获取飞机采购单价
     *
     * @return Cost - 飞机采购单价
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * 设置飞机采购单价
     *
     * @param cost 飞机采购单价
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * 获取飞机抗伤害的总点数
     *
     * @return DamagePoints - 飞机抗伤害的总点数
     */
    public Integer getDamagepoints() {
        return damagepoints;
    }

    /**
     * 设置飞机抗伤害的总点数
     *
     * @param damagepoints 飞机抗伤害的总点数
     */
    public void setDamagepoints(Integer damagepoints) {
        this.damagepoints = damagepoints;
    }

    /**
     * 获取受油速度
     *
     * @return FuelOffloadRate - 受油速度
     */
    public Integer getFueloffloadrate() {
        return fueloffloadrate;
    }

    /**
     * 设置受油速度
     *
     * @param fueloffloadrate 受油速度
     */
    public void setFueloffloadrate(Integer fueloffloadrate) {
        this.fueloffloadrate = fueloffloadrate;
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
     * 获取飞机名称
     *
     * @return Name - 飞机名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置飞机名称
     *
     * @param name 飞机名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取可见性
     *
     * @return Visibility - 可见性
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * 设置可见性
     *
     * @param visibility 可见性
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}