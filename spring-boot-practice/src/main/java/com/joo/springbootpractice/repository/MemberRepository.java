package com.joo.springbootpractice.repository;

import java.util.List;

import com.joo.springbootpractice.entity.MemberEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    public List<MemberEntity> findById(String id);

    public List<MemberEntity> findByName(String name);

    public List<MemberEntity> findByNameLike(String keyword);
}
