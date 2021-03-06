package com.first.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CslVO{
	private int id;
	private String uid;
	private String tid;
	private String csl_workoutday;
	private Date csl_date;
	private String csl_time;
	private String csl_read;
	private String csl_progress;
	
	// for INSERT
	public CslVO(String uid, String tid, String csl_workoutday, Date csl_date, String csl_time) {
		super();
		this.uid = uid;
		this.tid = tid;
		this.csl_workoutday = csl_workoutday;
		this.csl_date = csl_date;
		this.csl_time = csl_time;
	}
	
	// for UPDATE: 상담 희망 날짜, 시간 수정
	public CslVO(int id, Date csl_date, String csl_time) {
		super();
		this.id = id;
		this.csl_date = csl_date;
		this.csl_time = csl_time;
	}
	
	// for UPDATE: 수락 여부 / 상담 여부 수정
	public CslVO(int id, String csl_read) {
		super();
		this.id = id;
		this.csl_read = csl_read;
	}



	

}
