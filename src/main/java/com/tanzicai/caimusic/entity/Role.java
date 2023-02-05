package com.tanzicai.caimusic.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends BaseEntity {
    private String name;

    private String title;
}
