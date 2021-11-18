package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.NewsTypeDao;
import entity.News;
import entity.NewsType;
import util.DBHelper;

public class NewsTypeDaoImpl implements NewsTypeDao {
	private DBHelper db = new DBHelper();

	@Override
	public List<NewsType> findAll() {
		List<NewsType> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,name from news_type");
			db.ps = db.con.prepareStatement(sb.toString());
			db.rs = db.ps.executeQuery();
			list = new ArrayList<NewsType>();
			while (db.rs.next()) {				
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
	public List<NewsType> findTypeId(int id) {
		List<NewsType> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select nt.name from news as n inner join news_type as nt on n.type_id = nt.id where n.id = ?");
			db.ps= db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			db.rs= db.ps.executeQuery();
			list = new ArrayList<NewsType>(16);
			while(db.rs.next()) {
				NewsType newsType = new NewsType();
				newsType.setName(db.rs.getString(1));
				list.add(newsType);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return list;
	}
}
