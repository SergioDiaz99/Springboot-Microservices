package com.programming.user.ValueObject;

import com.programming.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTemplateVO {

    private User user;
    private Department department;

}
