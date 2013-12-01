package com.ensimag.api.bank;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public class Bank implements IBank {

	private List<IAccount> _listAccount;
	private long _bankId;
	
	public Bank(long bankId) {
		super();
		_listAccount = new ArrayList<IAccount>();
		_bankId = bankId;
		System.out.println("Banque "+ _bankId + " crée");
	}

	public long getBankId() {
		return _bankId;
	}

	public List<IAccount> getAccounts() throws RemoteException {
		return _listAccount;
	}

	public IAccount getAccount(long number) throws AccountNotFoundException,
			RemoteException {
		IAccount searchedAccount = null;
		for(IAccount acc : _listAccount) {
			if (acc.getAccountNumber() == number) {
				searchedAccount = acc;
				break;
			}
		}
		if (searchedAccount == null)
			throw new AccountNotFoundException();
		return searchedAccount;
	}

	public IAccount openAccount(IUser user) throws RemoteException {
		IAccount newAccount = new Account(user, 0, 0);
		_listAccount.add(newAccount);
		return newAccount;
	}

	public boolean closeAccount(long number) throws AccountNotFoundException,
			RemoteException {
		boolean isDeleted = false;
		for(int i = 0 ; i < _listAccount.size(); ++i)
		{
			if (_listAccount.get(i).getAccountNumber() == number) {
				_listAccount.remove(i);
				isDeleted = true;
			}
		}
		if (!isDeleted)
			throw new AccountNotFoundException();
		return isDeleted;
	}

}
