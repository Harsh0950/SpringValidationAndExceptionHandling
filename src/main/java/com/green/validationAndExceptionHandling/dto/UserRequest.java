package com.green.validationAndExceptionHandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotNull(message = "username should not be null")
    private String name;

    @Email(message = "email address is invalid")
    private String email;

    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile no")
    private String mobile;

    private String gender;

    @Min(18)
    @Max(60)
    private int age;

    @NotBlank
    private String nationality;
}
