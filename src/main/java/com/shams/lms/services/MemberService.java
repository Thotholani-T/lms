package com.shams.lms.services;

import com.shams.lms.models.Member;
import com.shams.lms.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    //Add new Member to database
    public void save(Member member) {
        memberRepository.save(member);
    }

    //get Member by id
    public Optional<Member> findById(long id) {
        return memberRepository.findById(id);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public void update(Member member) {
        memberRepository.save(member);
    }
}
