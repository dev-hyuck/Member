package com.example.member.com.controller;

import com.example.member.com.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor

public class MemberController {

    private final MemberService memberService;
}
