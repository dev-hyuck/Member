package com.example.member.com.service;

import com.example.member.com.dto.*;
import com.example.member.com.entity.Member;
import com.example.member.com.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

// 서비스 클래스는 자동적으로 나와야 되는거야 !!!
//@Service
//@RequiredArgsConstructor 붙혀야함.

public class MemberService {

    private final MemberRepository memberRepository;

    // >> CUD
    // Read
    // >> 톱니바퀴가 물려서 돌아가는 것 처럼 표현 해야 된다.
    //
    @Transactional // >> 기본 값이 false임 !
    public MemberCreateResponse save(MemberCreateRequest request) {
        Member member = new Member(request.getName());
        Member savedMember = memberRepository.save(member); // 저장한 놈을 받아 와야지 어디에? member에
        return new MemberCreateResponse(
                savedMember.getId(),
                savedMember.getName(),
                savedMember.getModifiedAt(),
                savedMember.getCreatedAt()

        );
    }

    @Transactional(readOnly = true)
    public  List<MemberGetResponse> findAll() { // 전체 조회 ..
        memberRepository.findAll(); // >> 전부 찾을게요 ( find All )
        List<Member> members = memberRepository.findAll(); // 왜 리스트 멤버일까 ? : 멤버레포지토리는 멤버 저장소잖아
        List<MemberGetResponse> dtos = new ArrayList<>(); // MemberGetResponse에 새로운 그릇을 담아야 한다. 그래서 새로운 그릇을 만든거임
        for (Member member : members) {
            MemberGetResponse response = new MemberGetResponse(
                    member.getId(),
                    member.getName(),
                    member.getModifiedAt(),
                    member.getCreatedAt()
            );
            dtos.add(response);
        }
        return dtos;
    }
    @Transactional(readOnly = true)
    public  MemberGetResponse findOne(Long membersId) {
            Member member = memberRepository.findById(membersId).orElseThrow(
                    () -> new IllegalArgumentException("없는 멤버입니다.")
            );
            MemberGetResponse response = new MemberGetResponse(
                    member.getId(),
                    member.getName(),
                    member.getModifiedAt(),
                    member.getCreatedAt()
            );
            return  response;
    }

    @Transactional
    public MemberUpdateResponse update(Long membersId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(membersId).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버 입니다.")
        );
        member.update(request.getName());
        return new MemberUpdateResponse(
                member.getId(),
                member.getName(),
                member.getModifiedAt(),
                member.getCreatedAt()
        );
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);
        // 존재하지 않으면
        if (!existence) {
            throw new IllegalStateException("없는 멤버입니다. 찾지 말아주세요!");
        }
        // 존재하면
        memberRepository.deleteById(memberId);
    }
}
