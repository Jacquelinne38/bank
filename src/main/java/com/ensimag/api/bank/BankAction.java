package com.ensimag.api.bank;

import java.io.Serializable;

public class BankAction implements IBankAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum ACTION {
	ADD_ACCOUNT,
	ADD_MONEY,
	REMOVE_MONEY,
	ALLOW_OVERDRAW,
	REMOVE_ACCOUNT
	}
	
	private ACTION _action;
	
	public BankAction(ACTION action){
		_action = action;
	}
	
	public Serializable execute(IBankNode node) throws Exception {
		
		return null;
	}
}
