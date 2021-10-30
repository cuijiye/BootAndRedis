package com.example.bootredis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 8238807585144166817L;
    private String name;
    private Integer age;
}
