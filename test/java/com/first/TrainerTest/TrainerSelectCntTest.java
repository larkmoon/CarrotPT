package com.first.TrainerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.first.biz.TrainerBiz;
import com.first.vo.TrainerVO;

@SpringBootTest
class TrainerSelectCntTest {

	@Autowired
	TrainerBiz biz;

	@Test
	void contextLoads() {
		try {
			int cnt = biz.getcnt();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
