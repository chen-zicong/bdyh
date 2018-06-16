package com.bdyh.entity;

public class Teacher {
    private Integer teacherId;

    private String username;

    private String password;

    private String teacherName;

    private String teacherImg;

    private String teacherIntro;

    private Integer sex;

    private String telephone;

    private String email;

    private String joinTime;

    private String major;

    private String loginTime;

    private Integer loginNumber;

    private Integer status;

    private Integer districtId;

    private Integer roleId;

    private Integer collectNumber;

    private Integer provinceId;

    private Integer cityId;

    private Integer agentId;

    public Teacher(Integer teacherId, String username, String password, String teacherName, String teacherImg, String teacherIntro, Integer sex, String telephone, String email, String joinTime, String major, String loginTime, Integer loginNumber, Integer status, Integer districtId, Integer roleId, Integer collectNumber, Integer provinceId, Integer cityId, Integer agentId) {
        this.teacherId = teacherId;
        this.username = username;
        this.password = password;
        this.teacherName = teacherName;
        this.teacherImg = teacherImg;
        this.teacherIntro = teacherIntro;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.joinTime = joinTime;
        this.major = major;
        this.loginTime = loginTime;
        this.loginNumber = loginNumber;
        this.status = status;
        this.districtId = districtId;
        this.roleId = roleId;
        this.collectNumber = collectNumber;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.agentId = agentId;
    }

    public Teacher() {
        super();
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherImg() {
        return teacherImg;
    }

    public void setTeacherImg(String teacherImg) {
        this.teacherImg = teacherImg == null ? null : teacherImg.trim();
    }

    public String getTeacherIntro() {
        return teacherIntro;
    }

    public void setTeacherIntro(String teacherIntro) {
        this.teacherIntro = teacherIntro == null ? null : teacherIntro.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String joinTime) {
        this.joinTime = joinTime == null ? null : joinTime.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime == null ? null : loginTime.trim();
    }

    public Integer getLoginNumber() {
        return loginNumber;
    }

    public void setLoginNumber(Integer loginNumber) {
        this.loginNumber = loginNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }
}