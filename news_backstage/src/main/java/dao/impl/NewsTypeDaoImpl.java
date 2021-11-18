package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.NewsTypeDao;
import entity.NewsType;
import utils.DBHelper;

public class NewsTypeDaoImpl implements NewsTypeDao {
	private DBHelper db = new DBHelper();

	@Override
	public List<NewsType> findNewsTypeById(int id) {
		List<NewsType> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,`name` from news_type order by id = ? desc");
			db.ps=db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			db.rs=db.ps.executeQuery(); 
			list = new ArrayList<NewsType>();
			while(db.rs.next()) {
				NewsType newsType = new NewsType();
				newsType.setId(db.rs.getInt(1));
				newsType.setName(db.rs.getString(2));
				list.add(newsType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return list;
	}

	@Override
	public List<NewsType> findAllNewsType() {
		List<NewsType> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,`name` from news_type");
			db.ps=db.con.prepareStatement(sb.toString());
			db.rs=db.ps.executeQuery(); 
			list = new ArrayList<NewsType>();
			while(db.rs.next()) {
				NewsType newsType = new NewsType();
				newsType.setId(db.rs.getInt(1));
				newsType.setName(db.rs.getString(2));
				list.add(newsType);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return list;
	}
}
