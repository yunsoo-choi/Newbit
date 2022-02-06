package com.ssafy.newbit.model.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.newbit.model.PostDto;
import com.ssafy.newbit.model.PostTextDto;
import com.ssafy.newbit.model.mapper.PostMapper;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public boolean writePost(PostDto postDto) throws Exception {
		// TODO Auto-generated method stub
		if(postDto.getPostText() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(PostMapper.class).writePost(postDto) == 1;
	}

	@Override
	public List<PostDto> listPost(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).listPost(map);
	}

	@Override
	public boolean editPost(PostTextDto postTextDto) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).editPost(postTextDto) == 1;
	}

	@Override
	public boolean deletePost(int postCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).deletePost(postCode) == 1;
	}

	@Override
	public PostDto getPost(int postCode) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("getpost 호출 : " + postCode);
		PostDto post = sqlSession.getMapper(PostMapper.class).getPost(postCode);
		if(post ==null)
			System.out.println("null");
		return post;
	}

	@Override
	public List<PostDto> listUserPost(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).listUserPost(map);
	}

	@Override
	public void updateScrap(int postCode) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(PostMapper.class).updateScrap(postCode);
	}

	@Override
	public void updateLike(int postCode) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(PostMapper.class).updateLike(postCode);
	}

	@Override
	public void updateComment(HashMap<String, Integer> map) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(map.get("count"));
		System.out.println(map.get("postCode"));
		sqlSession.getMapper(PostMapper.class).updateComment(map);
		
	}

	@Override
	public List<Integer> getFollowingList(int userCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(PostMapper.class).getFollowingList(userCode);
	}

	

}
