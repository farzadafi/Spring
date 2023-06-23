package com.farzadafi.jdbctemplate.entity.base;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseEntity <ID extends Serializable>{
    private ID id;
}