package com.first.CslTest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.CslBiz;
import com.first.vo.CslVO;

@SpringBootTest
class CslSelectAllTest {

	@Autowired
	CslBiz biz;
	
	@Test
	void contextloads() {
		try {
			List<CslVO> list = biz.get();
			for (CslVO obj : list) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
