package com.mba.helper;

import com.mba.beans.UserpasswordToken;

public class SecurityManager {
	private static SecurityManager instance;
	private ThreadLocal<UserpasswordToken> threadLocal;

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
		UserpasswordToken token = new UserpasswordToken(username, password);
		threadLocal.set(token);
	}

	public void logout() {
		threadLocal.set(null);
	}

	public boolean authenticate() {
		UserpasswordToken token = null;

		token = threadLocal.get();
		if (token != null) {
			if (token.getUsername().equals("bob") && token.getPassword().equals("welcome1")) {
				return true;
			}
		}
		return false;
	}

	public String getLoggedInUser() {
		UserpasswordToken token = null;

		token = threadLocal.get();
		if (token != null) {
			return token.getUsername();
		}
		return null;
	}
}
