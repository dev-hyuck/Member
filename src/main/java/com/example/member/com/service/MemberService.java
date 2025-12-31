package com.example.member.com.service;

import com.example.member.com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

// 자동적으로 나와야 함

public class MemberService {

    private final MemberRepository memberRepository;
}
