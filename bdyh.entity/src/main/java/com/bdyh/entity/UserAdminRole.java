package com.bdyh.entity;

public class UserAdminRole {
    private Integer roleId;

    private String roleName;

    private String roleDesc;

    private String rolePowers;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
    }

    public String getRolePowers() {
        return rolePowers;
    }

    public void setRolePowers(String rolePowers) {
        this.rolePowers = rolePowers == null ? null : rolePowers.trim();
    }
}