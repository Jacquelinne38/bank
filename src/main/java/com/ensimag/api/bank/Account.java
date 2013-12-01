package com.ensimag.api.bank;

public class Account implements IAccount {

	private IUser _user;
	private long _accountNumber = -1;
	private int _money = 0;
	private int _allowedOverdraw = 0;
	static private int currentAccountNumber = 0;
	
	public Account(IUser user, int money, int allowedOverdraw) {
		super();
		_user = user;
		_money = money;
		_allowedOverdraw = allowedOverdraw;
		currentAccountNumber++;
		_accountNumber = currentAccountNumber;
		System.out.println("J'ai ajouté le user : "+currentAccountNumber+ " info : "+ user.getName()+", "+user.getFirstName()+", "+user.getAge());
	}
	
	public IUser getAccountUser() {
		return _user;
	}

	public long getAccountNumber() {
		return _accountNumber;
	}

	public int add(int amount) {
		_money += amount;
		return _money;
	}

	public int remove(int amount) throws NotEnoughMoneyException {
		int tmpMoney = _money - amount;
		if ((tmpMoney >= 0) || (tmpMoney >= _allowedOverdraw))
			_money -= amount;
		else
			throw new NotEnoughMoneyException(this);
		return _money;
	
		
	}

	public int getTotal() {
		return _money;
	}

	public int setAllowedOverdraw(int overdraw) {
		_allowedOverdraw = overdraw;
		return _allowedOverdraw;
	}

}
