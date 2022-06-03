package com.ovolaks.simpletodo.application.dto.user;

import com.ovolaks.simpletodo.application.validators.UsernameUniq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDto implements Serializable {

    @NotBlank(message = "Username can not be blank")
    @UsernameUniq
    private String username;

    @NotNull
    @Length(min = 8, message = "Password length must be more than 8 characters")
    private String password;

    @NotBlank(message = "Password confirm can not be blank")
    private String passwordConfirm;

    private String firstName;

    private String lastName;

    @AssertTrue(message = "Passwords not confirm")
    public boolean isConfirmPasswords() {
        if (password != null) {
            return password.equals(passwordConfirm);
        }
        return false;
    }
}
