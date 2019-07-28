package com.guli.teacher.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EduException extends RuntimeException {

    private Integer code;

    private String message;

}
