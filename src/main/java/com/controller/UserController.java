package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {
	@Autowired
	UserDao userDao;
	
	/*
	 * @PostMapping("user") // it doesn't matter if we write /user or only user
	 * public String addUser(UserBean userBean) {
	 * 
	 * System.out.println(userBean.getFirstname());
	 * System.out.println(userBean.getLastname());
	 * System.out.println(userBean.getEmail());
	 * System.out.println(userBean.getPassword()); userDao.insertUser(userBean);
	 * return "user added"; }
	 */
	
	@PostMapping("/user")
	public ResponseBean<UserBean> addUser(UserBean userBean, @Value("${x}") String x) {
		System.out.println(userBean.getFirstname());
		System.out.println(userBean.getLastname());
		System.out.println(userBean.getEmail());
		System.out.println(userBean.getPassword());
		// here we need to call add user from dao
		userDao.insertUser(userBean);
		ResponseBean rb = new ResponseBean();
		rb.setCode(200);
		rb.setMessage("User Added");
		rb.setData(userBean);
		System.out.println("x ==>  " + x);
		return rb;

	}
	@GetMapping("/users")
	public ArrayList<UserBean> listUsers() {
		return userDao.listUsers();
	}

	@GetMapping("/user/{email}")
	public UserBean getUser(@PathVariable("email") String email) {
		UserBean userBean = userDao.getUserByEmail(email);
		return userBean;
		
	}
	
	@DeleteMapping("user/{email}")
	public ArrayList<UserBean> deleteUser(@PathVariable("email") String email){
		 
		userDao.deleteUser(email);
		return userDao.listUsers();
	}

	

}
