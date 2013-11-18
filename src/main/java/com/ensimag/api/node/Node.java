package com.ensimag.api.node;

import java.awt.TrayIcon.MessageType;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import com.ensimag.api.message.IAck;
import com.ensimag.api.message.IResult;
import com.ensimag.api.node.INode;

public class Node implements INode<MessageType> {

	private List<INode> _lstNode;
	
	
	public long getId() throws RemoteException {
		// TODO Auto-generated method stub
		return 100;
	}

	public void onMessage(MessageType message) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void onAck(IAck ack) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void addNeighboor(INode<MessageType> neighboor)
			throws RemoteException {
		// TODO Auto-generated method stub
		if (!_lstNode.contains(neighboor))
			_lstNode.add(neighboor);
		System.out.println("neighboor ajoute");

	}

	public void removeNeighboor(INode<MessageType> neighboor)
			throws RemoteException {
		// TODO Auto-generated method stub
		_lstNode.remove(neighboor);
		
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

}
