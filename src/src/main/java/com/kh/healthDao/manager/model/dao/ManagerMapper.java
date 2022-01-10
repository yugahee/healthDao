package com.kh.healthDao.manager.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.healthDao.manager.model.vo.Qna;

@Mapper
public interface ManagerMapper{
	
	// 전체 문의글 조회
	// List<Qna> listAllQna();
	
	// 문의글 답변
	Qna listQna(int qNo);

	// 답변쓰기
	int managerQAnswer(Qna qna);

	// 페이징 된 게시물 조회
	int getInquiryCount();
	List<Qna> listInquiryInventory(Map<String, Object> pageRow);

	

}