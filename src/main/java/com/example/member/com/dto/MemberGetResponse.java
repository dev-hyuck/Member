package com.example.member.com.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter

public class MemberGetResponse {

    private final long id;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public MemberGetResponse(long id, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
