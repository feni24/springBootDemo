package com.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	ArrayList<UserBean> users = new ArrayList<>();

	public void insertUser(UserBean userBean) {
		users.add(userBean);
	}

	public ArrayList<UserBean> listUsers() {
		return users;
	}

	public UserBean getUserByEmail(String email) {
		for (UserBean u : users) {
			if (u.getEmail().equals(email)) {
				return u;
			}
		}

		return null; 
	}

	public void deleteUser(String email) {
		for (UserBean u : users) {
			if (u.getEmail().equals(email)) {
				users.remove(u);
				break;
			}

		}

	}

	/*
	 * public void updateUser(String fnOld,String fnNew) { for(UserBean u:users) {
	 * if(u.getFirstname().equals(fnOld)) { u.setFirstname(fnNew); } }
	 * 
	 * }
	 */
}
