package com.first.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.first.frame.Biz;
import com.first.mapper.ReportMapper;
import com.first.mapper.TrainerMapper;
import com.first.vo.NewAlarmVO;
import com.first.vo.ReportVO;

@Service("reportbiz")
public class ReportBiz implements Biz<Integer, ReportVO> {
	
	@Autowired
	ReportMapper dao;
	
	@Autowired
	TrainerMapper tdao;
	
	@Override
	public void register(ReportVO v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(ReportVO v) throws Exception {
		dao.update(v);
	}

	@Override
	public ReportVO get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<ReportVO> get() throws Exception {
		return dao.selectall();
	}
	
	public int getcnt(String status) throws Exception{
		return dao.selectcnt(status);
	}
	
	// status='대기중'인 트레이너, 신고 개수 구하기
	public NewAlarmVO selectalarms(String tstatus, String rstatus) throws Exception{
		int newtrainercnt = tdao.selectcnt(tstatus);
		int newreportcnt = dao.selectcnt(rstatus);
		NewAlarmVO obj = new NewAlarmVO(newtrainercnt, newreportcnt);
		return obj;
	}
	
	public List<ReportVO> getbypage(int pageNo, int amount, String rp_status) throws Exception{
		int offset = (pageNo - 1) * amount;
		List<ReportVO> list = dao.selectbypage(pageNo, amount, offset, rp_status);
		return list;
	}

	
	
}
