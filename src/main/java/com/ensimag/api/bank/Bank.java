package com.ensimag.api.bank;

import java.rmi.RemoteException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

public class Bank implements IBank {

	public List<IAccount> getAccounts() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public IAccount getAccount(long number) throws AccountNotFoundException,
			RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public IAccount openAccount(IUser user) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean closeAccount(long number) throws AccountNotFoundException,
			RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public long getBankId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
