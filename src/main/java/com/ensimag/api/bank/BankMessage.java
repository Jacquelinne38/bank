package com.ensimag.api.bank;

import com.ensimag.api.message.EnumMessageType;

public class BankMessage implements IBankMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBankAction _bankAction;
	private long _messageId;
	private long _originalBankSenderId;
	private long _senderId;
	private long _destinationBank;
	private EnumMessageType _messageType;
	
	public BankMessage(long messageId, IBankAction action, long originalBankSenderId, long senderId, long destinationBank, EnumMessageType messageType) {
		super();
		_bankAction = action;
		_originalBankSenderId = originalBankSenderId;
		_senderId = senderId;
		_destinationBank = destinationBank;
		_messageType = messageType;
		_messageId = messageId;
	}

	public IBankAction getAction() {
		return _bankAction;
	}
	
	public IBankMessage clone() {
		IBankMessage tmp = new BankMessage(getMessageId(), getAction(), getOriginalBankSenderId(), getSenderId(), getDestinationBankId(), getMessageType());
		return tmp;
	}

	public long getMessageId() {
		return _messageId;
	}

	public long getOriginalBankSenderId() {
		return _originalBankSenderId;
	}

	public long getSenderId() {
		return _senderId;
	}

	public void setSenderId(long senderId) {
		_senderId = senderId;
		
	}

	public long getDestinationBankId() {
		return _destinationBank;
	}

	public EnumMessageType getMessageType() {
		return _messageType;
	}

}
