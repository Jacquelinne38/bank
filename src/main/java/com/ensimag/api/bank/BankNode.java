package com.ensimag.api.bank;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.ensimag.api.message.IAck;
import com.ensimag.api.message.IResult;
import com.ensimag.api.node.INode;

public class BankNode implements IBankNode {

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

	public long getId() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void onMessage(IBankMessage message) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void onAck(IAck ack) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void removeNeighboor(INode<IBankMessage> neighboor)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	public List<IResult<? extends Serializable>> getResultForMessage(
			long messageId) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deliverResult(IResult<Serializable> result)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public void addNeighboor(INode<IBankMessage> neighboor)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

}
