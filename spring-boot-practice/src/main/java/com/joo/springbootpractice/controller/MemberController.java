package com.joo.springbootpractice.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joo.springbootpractice.entity.MemberEntity;
import com.joo.springbootpractice.service.MemberService;

@RestController
@RequestMapping("member")
public class MemberController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MemberService memberService;
	
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<List<MemberEntity>> getAllMembers() {
		List<MemberEntity> members = memberService.findAll();
		return new ResponseEntity<List<MemberEntity>>(members, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MemberEntity> getMember(@PathVariable("mbrNo") Long mbrNo) {
		Optional<MemberEntity> member = memberService.findById(mbrNo);
		return new ResponseEntity<MemberEntity>(member.get(), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> deleteMember(@PathVariable("mbrNo") Long mbrNo) {
		memberService.deleteById(mbrNo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/{mbrNo}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<MemberEntity> updateMember(@PathVariable("mbrNo") Long mbrNo, MemberEntity member) {
		memberService.updateById(mbrNo, member);
		return new ResponseEntity<MemberEntity>(member, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<MemberEntity> save (MemberEntity member) {
		return new ResponseEntity<MemberEntity>(memberService.save(member), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/saveMember", method = RequestMethod.GET)
	public ResponseEntity<MemberEntity> save (HttpServletRequest req, MemberEntity member) {
		return new ResponseEntity<MemberEntity>(memberService.save(member), HttpStatus.OK);
	}
	
	
}
