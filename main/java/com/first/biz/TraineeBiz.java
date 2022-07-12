package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.TraineeMapper;
import com.first.vo.TraineeVO;

@Service("traineebiz")
public class TraineeBiz implements Biz<String, TraineeVO> {

	@Autowired
	TraineeMapper dao;

	@Override
	public void register(TraineeVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(TraineeVO v) throws Exception {
		dao.update(v);

	}

	@Override
	public TraineeVO get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<TraineeVO> get() throws Exception {
		return dao.selectall();
	}

}
