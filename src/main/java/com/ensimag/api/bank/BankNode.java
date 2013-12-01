package com.ensimag.api.bank;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.ensimag.api.message.Ack;
import com.ensimag.api.message.IAck;
import com.ensimag.api.message.IResult;
import com.ensimag.api.message.Result;
import com.ensimag.api.node.INode;

public class BankNode implements IBankNode {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IBank _bank;
	private List<INode<IBankMessage>> _listNeighboor;
	private HashMap<Long, Result> _resultByMessage;
	private long _nodeId;
	private List<IResult<Serializable>> _listResult;	
	
	//Ensemble des voisins 
	private List<Long> _S;
	//Ensemble des voisins dont on attend un acquittement
	private List<Long> _waitS;
	//Voisin qui a envoyé un message
	private Long _up;
	//Boolean si on a déjà vu le message
	private Boolean _dejaVu;
	
	public BankNode(IBank bank) {
		super();
		_listNeighboor = new ArrayList<INode<IBankMessage>>();
		_listResult = new ArrayList<IResult<Serializable>>();
		_S = new ArrayList<Long>();
		_waitS = new ArrayList<Long>();
		_dejaVu = false;
		_up = null;
		_bank = bank;
		_nodeId = bank.getBankId();
	}
	
	public List<IAccount> getAccounts() throws RemoteException {
		return _bank.getAccounts();
	}

	public IAccount getAccount(long number) throws AccountNotFoundException,
			RemoteException {
		return _bank.getAccount(number);
	}

	public IAccount openAccount(IUser user) throws RemoteException {
		return _bank.openAccount(user);
		
	}

	public boolean closeAccount(long number) throws AccountNotFoundException,
			RemoteException {
		return _bank.closeAccount(number);
	}

	public long getId() throws RemoteException {
		return _nodeId;
	}
	
	private void SendToNeighboor(IBankMessage message) throws RemoteException {
		for(INode<IBankMessage> n : _listNeighboor) {
			n.onMessage(new BankMessage(message.getMessageId(), 
					message.getAction(), 
					getId(), 
					getId(), 
					message.getDestinationBankId(), 
					message.getMessageType()));
		}
	}
	
	private List<Long> AddIdNeighboor(List<INode<IBankMessage>> nodes) throws RemoteException {
		List<Long> tmp = new ArrayList<Long>();
		for(INode<IBankMessage> n : nodes ) {
			tmp.add(n.getId());
		}
		return tmp;
	}

	public void onMessage(IBankMessage message) throws RemoteException {
		//Si client on envoi au voisin, si bonne bank on execute
		if ( message.getSenderId() == -1 ) {
			if ( message.getDestinationBankId() == _nodeId ) {
				//Execute
			} else {
				SendToNeighboor(message);
				_waitS.add(e)
			}
		}
		
		//Si on a déjà vu le message on ne fait rien
		if (_messageRead.contains(message.getMessageId()))
			return;
		
		//Si le message est pour la banque on execute la tâche sinon on envoi le message a ses voisins
		if (message.getDestinationBankId() == _nodeId) {
			try {
				//L'action ne peut modifier qu'un account 
				Result result = new Result(message.getAction().execute(this), message.getMessageId());
				deliverResult(result);
				Ack ack = new Ack(getId(), message.getMessageId());
				for (INode<IBankMessage> neigh : _listNeighboor) {
					neigh.onAck(ack);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//
		else {
			for(INode<IBankMessage> neig : _listNeighboor) {
				neig.onMessage(message.clone());
			}
		}

	}

	public void onAck(IAck ack) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void removeNeighboor(INode<IBankMessage> neighboor)
			throws RemoteException {
		for(int i = 0 ; i < _listNeighboor.size(); ++i) {
			if (_listNeighboor.get(i).getId() == neighboor.getId())
				_listNeighboor.remove(i);
		}
	}

	public List<IResult<? extends Serializable>> getResultForMessage(
			long messageId) throws RemoteException {
		//IResult<List<IBankNode>> result = new IResult<List<IBankNode>>();
		/*try {
			deliverResult(new Result(getAccount(1)));
		} catch (AccountNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return null;
	}

	public Boolean deliverResult(IResult<Serializable> result) throws RemoteException {
		Boolean tmp = false;
		if (result != null ) {
			//_listResult.add(result);
			_resultByMessage.put(key, value)
			tmp = true;
		}
		return tmp;
		
	}

	public void addNeighboor(INode<IBankMessage> neighboor)
			throws RemoteException {
		_listNeighboor.add(neighboor);
	}


}
