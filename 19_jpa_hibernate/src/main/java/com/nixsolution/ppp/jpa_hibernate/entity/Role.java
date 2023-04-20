package com.nixsolution.ppp.jpa_hibernate.entity;

import jakarta.validation.constraints.Size;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;


    @Size(max = 50)
    @Column(name = "name")
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
