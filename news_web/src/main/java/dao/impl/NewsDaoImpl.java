package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.NewsDao;
import entity.News;
import entity.NewsType;
import util.DBHelper;

public class NewsDaoImpl implements NewsDao{
private DBHelper db = new DBHelper();
	@Override
	public List<News> findAll(int currentSize,int pageSize) {
		 List<News> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,title,`desc`,author,`content`,create_time,update_time,sm_img,me_img,la_img,type_id from news order by update_time desc limit ?,? ");
			db.ps=db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, currentSize);
			db.ps.setInt(2, pageSize);
			db.rs=db.ps.executeQuery();
			list = new ArrayList<News>(16);
			while(db.rs.next()) {
				News news = new News();
				news.setId(db.rs.getInt(1));
				news.setTitle(db.rs.getString(2));
				news.setDesc(db.rs.getString(3));
				news.setAuthor(db.rs.getString(4));
				news.setContent(db.rs.getString(5));
				news.setCreateTime(db.rs.getDate(6));
				news.setUpdateTime(db.rs.getDate(7));
				news.setSmImg(db.rs.getString(8));
				news.setMeImg(db.rs.getString(9));
				news.setLaImg(db.rs.getString(10));
				news.setTypeId(db.rs.getInt(11));
				list.add(news);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return list;
	}
	@Override
	public List<News> findDetail(int id) {
		List<News> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,title,`desc`,author,`content`,create_time,update_time,sm_img,me_img,la_img,type_id from news where id= ?");
			db.ps= db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			db.rs= db.ps.executeQuery();
			list = new ArrayList<News>(16);
			while(db.rs.next()) {
				News news = new News();
				news.setId(db.rs.getInt(1));
				news.setTitle(db.rs.getString(2));
				news.setDesc(db.rs.getString(3));
				news.setAuthor(db.rs.getString(4));
				news.setContent(db.rs.getString(5));
				news.setCreateTime(db.rs.getDate(6));
				news.setUpdateTime(db.rs.getDate(7));
				news.setSmImg(db.rs.getString(8));
				news.setMeImg(db.rs.getString(9));
				news.setLaImg(db.rs.getString(10));
				news.setTypeId(db.rs.getInt(11));
				list.add(news);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return list;
	}
	@Override
	public List<News> findHotNews() {
		List<News> list = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,title,`desc`,author,`content`,create_time,update_time,sm_img,me_img,la_img,type_id from news order by update_time desc limit 6;");
			db.ps=db.con.prepareStatement(sb.toString());
			db.rs=db.ps.executeQuery();
			list = new ArrayList<News>(16);
			while(db.rs.next()) {
				News news = new News();
				news.setId(db.rs.getInt(1));
				news.setTitle(db.rs.getString(2));
				news.setDesc(db.rs.getString(3));
				news.setAuthor(db.rs.getString(4));
				news.setContent(db.rs.getString(5));
				news.setCreateTime(db.rs.getDate(6));
				news.setUpdateTime(db.rs.getDate(7));
				news.setSmImg(db.rs.getString(8));
				news.setMeImg(db.rs.getString(9));
				news.setLaImg(db.rs.getString(10));
				news.setTypeId(db.rs.getInt(11));
				list.add(news);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return list;
	}
	@Override
	public int count() {
		int count = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select count(1) from news");
			db.ps=db.con.prepareStatement(sb.toString());
			db.rs = db.ps.executeQuery();
			if(db.rs.next()) {
				count = db.rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return count;
	}
}
