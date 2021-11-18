package service.impl;

import java.util.List;

import dao.NavDao;
import dao.impl.NavDaoImpl;
import entity.Nav;
import service.NavService;

public class NavServiceImpl implements NavService{
private NavDao nd = new NavDaoImpl();
	@Override
	public List<Nav> findAll() {
		return nd.findAll();
	}

}
