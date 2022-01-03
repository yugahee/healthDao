package com.example.demo.main.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner {
	
	/*
	MAIN_NO	번호	NUMBER
	MAIN_NAME	배너명	VARCHAR2(50 BYTE)
	MAIN_RANK	순번	NUMBER
	MAIN_URL	URL정보	VARCHAR2(100 BYTE)
	MAIN_STATUS	상태	VARCHAR2(1 BYTE)
	*/
	
	private int main_no;			// 배너 번호
	private String main_name;		// 배너명
	private int main_rank;			// 순번
	private String main_url;		// URL정보
	private String main_status;		// 상태
	
}
