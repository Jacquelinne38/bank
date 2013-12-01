package com.ensimag.api.message;

public class Ack implements IAck {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long _senderId;
	private long _ackMessageId;
	
	public Ack(long senderId, long ackId) {
		super();
		_senderId = senderId;
		_ackMessageId = ackId;
	}

	public long getAckSenderId() {
		return _senderId;
	}

	public long getAckMessageId() {
		return _ackMessageId;
	}

}
