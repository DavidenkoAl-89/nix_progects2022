package com.nixsolution.ppp.servlet_jsp.entity;

public class Role {
    java.lang.Long roleId;
    String name;

    public Role() {
    }


    public Role(java.lang.Long roleId) {
        this.roleId = roleId;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(java.lang.Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }


    public java.lang.Long getRoleId() {
        return roleId;
    }

    public void setRoleId(java.lang.Long id) {
        this.roleId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + roleId +
                ", name='" + name + '\'' +
                '}';
    }

}
