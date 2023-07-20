package com.group.libraryapp.dto.user.request;

public class UserCreateRequest {
    private String name;
    private Integer age; // 대문자인 이유: null 표현할 수 있다., int: 널 X

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
