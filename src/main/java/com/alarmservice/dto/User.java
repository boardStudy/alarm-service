package com.alarmservice.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @NotBlank(message = "아이디는 필수 입력값 입니다.")
    @Pattern(regexp = "^([a-z0-9]){4,30}$", message = "아이디를 재확인해주세요.")
    private String userId;

    @NotBlank(message = "비밀번호는 필수 입력값 입니다.")
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,20}", message = "비밀번호를 재확인해주세요.")
    private String password;

    @NotBlank(message = "이메일은 필수 입력값 입니다..")
    @Email(message = "이메일을 재확인해주세요.")
    private String email;
    private LocalDateTime regDate;
    private LocalDateTime withdDate;
    private LocalDateTime updDate;
    private int withdStatus;
    @NotBlank(message = "이름은 필수 입력값 입니다.")
    private String name;

    @NotBlank(message = "전화번호는 필수 입력값 입니다.")
    @Pattern(regexp = "(01[016789])(\\d{3,4})(\\d{4})", message = "전화번호를 재확인해주세요..")
    private String phone;
    private int gender;
    private int userAuth;

}

