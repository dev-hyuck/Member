package com.example.member.com.controller;

import com.example.member.com.dto.*;
import com.example.member.com.service.MemberService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;
    // CRUD
    // ResponsEntity 무조건 사용한다고 보면 된다.
    // 제네릭
    @PostMapping("/members")
    public ResponseEntity<MemberCreateResponse> create (
            @RequestBody MemberCreateRequest request // 요청을 보내기 위한 자바로 만든것
    ) { // 멤버에 생성, 응답의 타입 메서드의 (리턴 타입)

        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.save(request));
        // >> 코드 분석 : 리스폰 엔티티의 상태를 생성하고 멤버 서비스를 저장한다 어디에? : request에
        // >> 생성이니까 CREATED.
    }

    @GetMapping("/members")
    public ResponseEntity<List<MemberGetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());

    }

    @GetMapping("/members/{membersId}")
    public ResponseEntity<MemberGetResponse> getOne( @PathVariable Long membersId ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findOne(membersId));
    }

    @PutMapping("/members/{memberId}")
    public ResponseEntity<MemberUpdateResponse> update(
            @PathVariable Long memberId,
            @RequestBody MemberUpdateRequest request
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.update(memberId, request));
    }

    @DeleteMapping("/members/{memberId}")
    public void delete(@PathVariable Long memberId)
    {
        memberService.delete(memberId);
    }


}
