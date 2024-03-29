package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.first.vo.ReportVO;

@Repository
@Mapper
public interface ReportMapper {
	public void insert(ReportVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(ReportVO obj) throws Exception;	
	public ReportVO select(int id) throws Exception;
	public List<ReportVO> selectall() throws Exception;
	public int selectcnt(String status) throws Exception;
	
	public List<ReportVO> selectbypage(@Param("pageNo")int pageNo, @Param("amount")int amount, @Param("offset")int offset, @Param("rp_status")String rp_status) throws Exception;
}
