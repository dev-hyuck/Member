package com.example.member.com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;

@Getter
@Entity
@Table(name = "members")
@NoArgsConstructor(access = AccessLevel.PROTECTED)

// >> 멤버는 extends(확장) BaseEntity를 상속 관계 생성
// 생성일 및 수정일을 확장 했으므로 BaseEntity를 사용할 수 있게 된거임.
// 그렇게 데이터를 저장 할 공간인 인터페이스 멤버 레퍼지토리로 보내게 된 거임.

public class Member extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }

}
