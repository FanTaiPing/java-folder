package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.NavDao;
import entity.Nav;
import util.DBHelper;

public class NavDaoImpl implements NavDao{
	private DBHelper db = new DBHelper();

	@Override
	public List<Nav> findAll() {
		List<Nav> list = null;
		try {
			db.openDB();
			StringBuffer sb =new StringBuffer();
			sb.append("select id,name from nav");
			db.ps= db.con.prepareStatement(sb.toString());
			db.rs= db.ps.executeQuery();
			list = new ArrayList<Nav>();
			while(db.rs.next()){
				Nav nav = new Nav();
				nav.setId(db.rs.getInt(1));
				nav.setName(db.rs.getString(2));
				list.add(nav);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return list;
	}
}
