package com.ensimag.api.message;

import java.io.Serializable;


public class Result implements IResult<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Serializable _data;
	private long _messageId;
	
	public Result(Serializable serializable, long messageId) {
		super();
		_data = serializable;
		_messageId = messageId;
	}
	
	public long getMessageId() {
		return _messageId;
	}

	public Serializable getData() {
		return _data;
	}

}
