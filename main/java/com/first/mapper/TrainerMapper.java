package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.first.vo.MajorVO;
import com.first.vo.StatusVO;
import com.first.vo.TrainerVO;

@Mapper
@Repository
public interface TrainerMapper{
	public void insert(TrainerVO obj) throws Exception;
	public void delete(String obj) throws Exception;
	public void update(TrainerVO obj) throws Exception;
	public TrainerVO select(String obj) throws Exception;
	public List<TrainerVO> selectall() throws Exception;
	
	public TrainerVO selectbyemail(String obj) throws Exception;
	public List<TrainerVO> selectauthorized(String loc, String major) throws Exception;
	public int selectcnt(String status) throws Exception;
	public List<TrainerVO> selectbypage(@Param("pageNo")int pageNo, @Param("amount")int amount, @Param("orderBy")String orderBy, @Param("offset")int offset, @Param("status")String status) throws Exception;
	public List<TrainerVO> selectforpreference(String custZip) throws Exception;
	
	public String selectbynamephone(String name, String phone) throws Exception;
	public String selectbyidemail(String id, String email) throws Exception;
	public String selectemailbyemail(String email) throws Exception;
	public String selectbyid(String id) throws Exception;
	
	public List<MajorVO> selectmajor() throws Exception;
	public List<StatusVO> selectstatus() throws Exception;
	
	public void updatestatus(TrainerVO obj) throws Exception;
	
	public void updateProfile(TrainerVO obj) throws Exception;
	public void updateAccount(TrainerVO obj) throws Exception;
	public void updatePassword(TrainerVO obj) throws Exception;

	// 아이디, 비밀번호 찾기에서 사용
	public void updatepwd(TrainerVO obj) throws Exception;
	
	//리뷰 평점 높은순 트레이너 5명
	public List<TrainerVO> selectbyrvrate() throws Exception;

}
