package me.yangjun.exception;

import me.yangjun.utils.LanguageUtils;

public class MyException extends RuntimeException {

	private static final long serialVersionUID = -5158455451629119532L;

	private String errCode;
	private String errMsg;

	public MyException() {
		super();
	}

	public MyException(String errCode, String errMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public MyException(String errCode, String errMsg, Throwable cause) {
		super(errCode + "_" + errMsg, cause);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public MyException(String errCode) {
		// this(errcode, LanguageUtils.get(Constants.RET_CODE_PREFIX + errCode));
		this(errCode, LanguageUtils.get("retcode.desc" + errCode));
	}

	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String toString() {
		return "MyException [errCode=" + errCode + ", errMsg=" + errMsg + "]";
	}
}
