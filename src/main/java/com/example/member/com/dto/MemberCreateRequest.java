package com.example.member.com.dto;

import lombok.Getter;

@Getter
// DTO 규칙 : 무조건 Getter 만들어야 함
// Request 객체는 생성자를 만들지 않는다 ?
public class MemberCreateRequest {

    private String name;
}
