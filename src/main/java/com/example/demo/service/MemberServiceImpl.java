package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.MemberDTO;
import com.example.demo.mapper.MemberMapper;


@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public List<MemberDTO> findMemberList() {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberList();
	}
	
	@Override
	public MemberDTO findMemberDetail(String id) {
		// TODO Auto-generated method stub
		return memberMapper.selectMemberDetail(id);
	}

	@Override
	public void registerMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		memberMapper.insertMember(memberDTO);
	}

	@Override
	public void removeMember(String id) {
		// TODO Auto-generated method stub
		memberMapper.deleteMember(id);
	}

	@Override
	public void changeMember(MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		memberMapper.updateMember(memberDTO);
	}

}