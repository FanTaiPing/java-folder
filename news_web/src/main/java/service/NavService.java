package service;

import java.util.List;

import entity.Nav;

public interface NavService {
	/**
	 * 查询所有导航栏内容
	 * @return
	 */
		List<Nav> findAll();
}
