package com.nixsolution.ppp.sql_jdbs.entiny;

public class Role {
    Long roleId;
    String name;

    public Role() {
    }

    public Role(Long roleId) {
        this.roleId = roleId;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(Long roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long id) {
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
