package com.mba.helper;

public class SecurityManager {
	private static SecurityManager instance;
	private ThreadLocal<UserPwdToken> threadLocal;

	private SecurityManager() {
		threadLocal = new ThreadLocal<>();
	}

	public static synchronized SecurityManager getInstance() {
		if (instance == null) {
			instance = new SecurityManager();
		}
		return instance;
	}

	public void login(String username, String password) {
		UserPwdToken token = new UserPwdToken(username, password);
		threadLocal.set(token);
	}

	public void logout() {
		threadLocal.set(null);
	}

	public boolean authenticate() {
		UserPwdToken token = null;

		token = threadLocal.get();
		if (token != null) {
			if (token.getUsername().equals("robert") && token.getPassword().equals("welcome1")) {
				return true;
			}
		}
		return false;
	}

	public String loggedInUser() {
		UserPwdToken token = null;
		
		token = threadLocal.get();
		if(token != null) {
			return token.getUsername();
		}
		return null;
	}
}
