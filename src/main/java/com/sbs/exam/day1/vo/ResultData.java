package com.sbs.exam.day1.vo;

import lombok.Getter;

public class ResultData {
	// S-1 S = 성공
	// F-1 F = 실패
	@Getter
	private String resultCode;
	@Getter
	private String msg;
	@Getter
	private Object data1;

	private ResultData() {

	}

	public static ResultData from(String resultCode, String msg) {
		return from(resultCode, msg, null);
	}

	public static ResultData from(String resultCode, String msg, Object data1) {
		ResultData rd = new ResultData();
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.data1 = data1;
		return rd;
	}

	public boolean isSuccess() {
		return resultCode.startsWith("S-1");
	}

	public boolean isFail() {
		return isSuccess() == false;
	}

	public static ResultData newData(ResultData joinRd, Object newData) {
		return from(joinRd.getResultCode(), joinRd.getMsg(), newData);
	}
}
