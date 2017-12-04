package com.koitt.board.dao;

import java.util.List;

import com.koitt.board.model.CommonException;
import com.koitt.board.model.UserInfo;

public interface UserInfoDao {

	public List<UserInfo> selectAll() throws CommonException;

	public UserInfo select(String email) throws CommonException;

	public void insert(UserInfo user) throws CommonException;

	public void insertUserTypes(UserInfo user) throws CommonException;

	public void delete(String email) throws CommonException;

	public void deleteUserTypes(String email) throws CommonException;

	public void update(UserInfo user) throws CommonException;
	
}
