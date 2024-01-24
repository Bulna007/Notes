package com.mba.helper;

public class SecurityManager {
	private static SecurityManager instance;
	private ThreadLocal<UnPwdToken> threadLocal;

	private SecurityManager() {
		threadLocal = new ThreadLocal<>();
	}

	public static synchronized SecurityManager getInstance() {
		if (instance == null) {
			instance = new SecurityManager();
		}
		return instance;
	}

	public void login(String un, String pwd) {
		UnPwdToken token = new UnPwdToken(un, pwd);
		threadLocal.set(token);
	}

	public void logout() {
		threadLocal.set(null);
	}

	public boolean authenticate() {
		UnPwdToken pwdToken = null;

		pwdToken = threadLocal.get();
		if (pwdToken != null) {
			if (pwdToken.getUn().equals("john") && pwdToken.getPassword().equals("welcome1")) {
				return true;
			}
		}
		return false;
	}

	public String loggedInUser() {
		UnPwdToken pwdToken = null;

		pwdToken = threadLocal.get();
		if (pwdToken != null) {
			return pwdToken.getUn();
		}
		return null;
	}
}
