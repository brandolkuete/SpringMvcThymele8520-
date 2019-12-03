package com.brandolkuete.springmvc.exception;

import org.zalando.problem.Status;

public class SprinMVCAppException extends Exception{

	private static final long serialVersionUID = 1L;
	private final Status httpStatus;

	public SprinMVCAppException(String msg, Status httpStatus) {
		super(msg);
		this.httpStatus = httpStatus;
	}

	public SprinMVCAppException(Throwable cause, Status httpStatus) {
		super(cause);
		this.httpStatus = httpStatus;
	}

	public Status getHttpStatus() {
		return httpStatus;
	}
}
