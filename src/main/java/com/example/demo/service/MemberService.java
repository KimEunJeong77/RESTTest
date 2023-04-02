package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.MemberDTO;

public interface MemberService {
	List<MemberDTO> findMemberList();
	MemberDTO findMemberDetail(String id);
	void registerMember(MemberDTO memberDTO);
	void removeMember(String id);
	void changeMember(MemberDTO memberDTO);
}