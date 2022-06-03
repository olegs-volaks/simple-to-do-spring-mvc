package com.ovolaks.simpletodo.application.dto;

import com.ovolaks.simpletodo.application.validators.Confirm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Confirm(baseField = "password", confirmFiled = "passwordConform", message = "Password not confirm")
public class CreateUserDto implements Serializable {

    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotBlank(message = "Password can not be blank")
    @Length(min = 8, message = "Password length must be more than 8 characters")
    private String password;

    @NotBlank(message = "Password confirm can not be blank")
    private String passwordConform;

    private String firstName;

    private String lastName;
}
