package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

@Table(name = "t_base")
public class Base {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 基地名称 0 大连基地 1 上海基地 2 福州基地 3 乌鲁木齐基地 4 济南基地 5 南宁基地 6 武汉基地 7 北京基地 8 兰州基地 9拉萨基地
     */
    private String name;

    /**
     * 辖区总面积（平方公里）
     */
    private Integer area;

    /**
     * 辖区军人总数
     */
    @Column(name = "soldier_num")
    private Long soldierNum;

    /**
     * 辖区平民雇员总数
     */
    @Column(name = "civilian_num")
    private Long civilianNum;

    /**
     * 辖区家属总数
     */
    @Column(name = "familymember_num")
    private Long familymemberNum;

    /**
     * 经度
     */
    private Integer longitude;

    /**
     * 维度
     */
    private Integer latitude;

    /**
     * 飞机
     */
    private String dataaircraft;

    /**
     * 卫星
     */
    private String datasatellite;

    /**
     * 组织机构
     */
    private String mygroup;

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
     * 获取基地名称 0 大连基地 1 上海基地 2 福州基地 3 乌鲁木齐基地 4 济南基地 5 南宁基地 6 武汉基地 7 北京基地 8 兰州基地 9拉萨基地
     *
     * @return name - 基地名称 0 大连基地 1 上海基地 2 福州基地 3 乌鲁木齐基地 4 济南基地 5 南宁基地 6 武汉基地 7 北京基地 8 兰州基地 9拉萨基地
     */
    public String getName() {
        return name;
    }

    /**
     * 设置基地名称 0 大连基地 1 上海基地 2 福州基地 3 乌鲁木齐基地 4 济南基地 5 南宁基地 6 武汉基地 7 北京基地 8 兰州基地 9拉萨基地
     *
     * @param name 基地名称 0 大连基地 1 上海基地 2 福州基地 3 乌鲁木齐基地 4 济南基地 5 南宁基地 6 武汉基地 7 北京基地 8 兰州基地 9拉萨基地
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取辖区总面积（平方公里）
     *
     * @return area - 辖区总面积（平方公里）
     */
    public Integer getArea() {
        return area;
    }

    /**
     * 设置辖区总面积（平方公里）
     *
     * @param area 辖区总面积（平方公里）
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * 获取辖区军人总数
     *
     * @return soldier_num - 辖区军人总数
     */
    public Long getSoldierNum() {
        return soldierNum;
    }

    /**
     * 设置辖区军人总数
     *
     * @param soldierNum 辖区军人总数
     */
    public void setSoldierNum(Long soldierNum) {
        this.soldierNum = soldierNum;
    }

    /**
     * 获取辖区平民雇员总数
     *
     * @return civilian_num - 辖区平民雇员总数
     */
    public Long getCivilianNum() {
        return civilianNum;
    }

    /**
     * 设置辖区平民雇员总数
     *
     * @param civilianNum 辖区平民雇员总数
     */
    public void setCivilianNum(Long civilianNum) {
        this.civilianNum = civilianNum;
    }

    /**
     * 获取辖区家属总数
     *
     * @return familymember_num - 辖区家属总数
     */
    public Long getFamilymemberNum() {
        return familymemberNum;
    }

    /**
     * 设置辖区家属总数
     *
     * @param familymemberNum 辖区家属总数
     */
    public void setFamilymemberNum(Long familymemberNum) {
        this.familymemberNum = familymemberNum;
    }

    /**
     * 获取经度
     *
     * @return longitude - 经度
     */
    public Integer getLongitude() {
        return longitude;
    }

    /**
     * 设置经度
     *
     * @param longitude 经度
     */
    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    /**
     * 获取维度
     *
     * @return latitude - 维度
     */
    public Integer getLatitude() {
        return latitude;
    }

    /**
     * 设置维度
     *
     * @param latitude 维度
     */
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
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
     * 获取组织机构
     *
     * @return mygroup - 组织机构
     */
    public String getMygroup() {
        return mygroup;
    }

    /**
     * 设置组织机构
     *
     * @param mygroup 组织机构
     */
    public void setMygroup(String mygroup) {
        this.mygroup = mygroup;
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