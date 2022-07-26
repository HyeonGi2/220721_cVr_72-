package com.sbs.exam.day1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.day1.service.MemberService;
import com.sbs.exam.day1.util.Ut;
import com.sbs.exam.day1.vo.Article;
import com.sbs.exam.day1.vo.Member;
import com.sbs.exam.day1.vo.ResultData;

@Controller
public class UsrMemberController {
	private MemberService memberService;

	public UsrMemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping("/usr/member/doJoin")
	@ResponseBody
	public ResultData doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNo,
			String email) {
		if (Ut.empty(loginId)) {
			return ResultData.from("F-1", "loginId(을)를 입력해주세요.");
		}
		if (Ut.empty(loginPw)) {
			return ResultData.from("F-2", "loginPw(을)를 입력해주세요.");
		}
		if (Ut.empty(name)) {
			return ResultData.from("F-3", "name(을)를 입력해주세요.");
		}
		if (Ut.empty(nickname)) {
			return ResultData.from("F-4", "nickname(을)를 입력해주세요.");
		}
		if (Ut.empty(cellphoneNo)) {
			return ResultData.from("F-5", "cellphoneNo(을)를 입력해주세요.");
		}
		if (Ut.empty(email)) {
			return ResultData.from("F-6", "email(을)를 입력해주세요.");
		}

		// S-1
		// 회원가입이 완료되었습니다.
		// 7
		ResultData joinRd = memberService.join(loginId, loginPw, name, nickname, cellphoneNo, email);
		// resultCode
		// msg
		//

		if (joinRd.isFail()) {
			return joinRd;
		}

		Member member = memberService.getMemberById((int) joinRd.getData1());

		return ResultData.newData(joinRd, member);
	}
}