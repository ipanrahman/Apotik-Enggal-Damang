package com.github.ipan97.enggal.damang.service;

import com.github.ipan97.enggal.damang.model.Member;
import com.github.ipan97.enggal.damang.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MemberService extends AbstractService<Member, Long> {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    protected JpaRepository<Member, Long> getRepository() {
        return memberRepository;
    }

}
