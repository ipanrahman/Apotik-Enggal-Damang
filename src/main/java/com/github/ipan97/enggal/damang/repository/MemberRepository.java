package com.github.ipan97.enggal.damang.repository;

import com.github.ipan97.enggal.damang.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
