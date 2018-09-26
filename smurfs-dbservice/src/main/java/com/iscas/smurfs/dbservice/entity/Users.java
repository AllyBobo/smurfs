package com.iscas.smurfs.dbservice.entity;

import javax.persistence.*;

@Table(name = "t_user")
public class Users {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 0 男 1 女
     */
    private String gender;

    /**
     * 籍贯
     */
    private String jiguan;

    /**
     * 身份（0 军官 1 士兵 2 学员 3 预备役 4 民兵）
     */
    private String type;

    /**
     * 军衔
     */
    private String rank;

    /**
     * 职位
     */
    private String position;

    /**
     * 累计飞行小时
     */
    @Column(name = "fly_hour")
    private Long flyHour;

    /**
     * 军龄
     */
    @Column(name = "army_age")
    private Integer armyAge;

    /**
     * 所属机构
     */
    @Column(name = "group_id")
    private String groupId;

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
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取0 男 1 女
     *
     * @return gender - 0 男 1 女
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置0 男 1 女
     *
     * @param gender 0 男 1 女
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取籍贯
     *
     * @return jiguan - 籍贯
     */
    public String getJiguan() {
        return jiguan;
    }

    /**
     * 设置籍贯
     *
     * @param jiguan 籍贯
     */
    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

    /**
     * 获取身份（0 军官 1 士兵 2 学员 3 预备役 4 民兵）
     *
     * @return type - 身份（0 军官 1 士兵 2 学员 3 预备役 4 民兵）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置身份（0 军官 1 士兵 2 学员 3 预备役 4 民兵）
     *
     * @param type 身份（0 军官 1 士兵 2 学员 3 预备役 4 民兵）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取军衔
     *
     * @return rank - 军衔
     */
    public String getRank() {
        return rank;
    }

    /**
     * 设置军衔
     *
     * @param rank 军衔
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /**
     * 获取职位
     *
     * @return position - 职位
     */
    public String getPosition() {
        return position;
    }

    /**
     * 设置职位
     *
     * @param position 职位
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 获取累计飞行小时
     *
     * @return fly_hour - 累计飞行小时
     */
    public Long getFlyHour() {
        return flyHour;
    }

    /**
     * 设置累计飞行小时
     *
     * @param flyHour 累计飞行小时
     */
    public void setFlyHour(Long flyHour) {
        this.flyHour = flyHour;
    }

    /**
     * 获取军龄
     *
     * @return army_age - 军龄
     */
    public Integer getArmyAge() {
        return armyAge;
    }

    /**
     * 设置军龄
     *
     * @param armyAge 军龄
     */
    public void setArmyAge(Integer armyAge) {
        this.armyAge = armyAge;
    }

    /**
     * 获取所属机构
     *
     * @return group_id - 所属机构
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置所属机构
     *
     * @param groupId 所属机构
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
}