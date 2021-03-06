package com.ssafy.newbit.model.service;

import java.sql.SQLException;
import java.util.*;

//import com.ssafy.newbit.controller.UserDetail;
import com.ssafy.newbit.model.UserDto;



public interface UserService{
	public boolean addUser(UserDto userDto) throws Exception;
	public boolean checkId(String userId) throws Exception;
	public boolean checkEmail(String userEmail) throws Exception;
	
	public boolean addUserKeyword(HashMap<String, Object> map) throws Exception;
	public boolean addUserIntro(HashMap<String, Object> map) throws Exception;

	public String checkLogin(String userEmail,  String userPassword) throws Exception;
	
	public UserDto getUser(int userCode) throws Exception;
	List<UserDto> getFollowingList(int userCode) throws Exception;
	List<UserDto> getFollowerList(int userCode) throws Exception;
	
	public boolean editUserInfo(UserDto usersDto) throws Exception;
	public boolean followUser(HashMap<String,Integer> map) throws Exception;
	public boolean unfollowUser(HashMap<String, Integer> map) throws Exception;

	public boolean deleteUser(int userCode) throws Exception;
	public List<UserDto> searchUserList(HashMap<String, Object> map) throws Exception;

	public List<UserDto> followRecommendation(HashMap<String, Object> map) throws Exception;
	
	public List<UserDto> getRandomUser(HashMap<String, Object> map) throws Exception;
	public List<UserDto> getFollowNoti(int userCode) throws Exception;
	
}
