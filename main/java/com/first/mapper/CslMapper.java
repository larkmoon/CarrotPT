package com.first.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.first.vo.CslNumVO;
import com.first.vo.CslVO;

@Repository
@Mapper
public interface CslMapper {
	public void insert(CslVO obj) throws Exception;
	public void delete(int id) throws Exception;
	public void update(CslVO obj) throws Exception;
	public void updateread(CslVO obj) throws Exception;
	public void updatematch(CslVO obj) throws Exception;	
	public CslVO select(int id) throws Exception;
	public List<CslVO> selectall() throws Exception;
	
	public List<CslVO> selectbyuid(String uid) throws Exception;
	public List<CslVO> selectbytid(String tid) throws Exception;
	public CslNumVO selectnumbyuid(String id) throws Exception;
	public CslNumVO selectnumbytid(String id) throws Exception;
	
	public void updateroomid(CslVO obj) throws Exception;
	public int selectroomid(int id) throws Exception;
	public List<CslVO> selectallroomid() throws Exception;
	public CslVO selectroombyroomid(int id) throws Exception;
	public String checkmatching(String uid, String tid) throws Exception;
}
