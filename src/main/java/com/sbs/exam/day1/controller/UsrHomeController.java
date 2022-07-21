package com.sbs.exam.day1.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.exam.day1.service.MemberService;
import com.sbs.exam.day1.vo.Article;

@Controller
public class UsrHomeController {
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String getString() {
		return "안녕하세요.";
	}

	
}