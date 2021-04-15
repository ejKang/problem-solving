package com.joo.springbootpractice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.joo.springbootpractice.entity.MemberEntity;
import com.joo.springbootpractice.repository.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<MemberEntity> findAll() {
    	List<MemberEntity> members = new ArrayList<>();
    	memberRepository.findAll().forEach(e -> members.add(e));
        return members;
    }
    
    public Optional<MemberEntity> findById(Long mbrNo) {
    	Optional<MemberEntity> member = memberRepository.findById(mbrNo);
    	return member;
    }
    
    public void deleteById(Long mbrNo) {
    	memberRepository.deleteById(mbrNo);
    }
    
    public MemberEntity save(MemberEntity member) {
    	memberRepository.save(member);
    	return member;
    }
    
    public void updateById(Long mbrNo, MemberEntity memeber) {
    	Optional<MemberEntity> fromDB = memberRepository.findById(mbrNo);
    	
    	if (fromDB.isPresent()) {
    		fromDB.get().setId(memeber.getId());
    		fromDB.get().setName(memeber.getName());
    		fromDB.get().setMbrNo(memeber.getMbrNo());
    		
    		memberRepository.save(memeber);
    	}
    }
}
