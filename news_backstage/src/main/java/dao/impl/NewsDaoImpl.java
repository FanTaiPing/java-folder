package dao.impl;

import java.util.ArrayList;
import java.util.List;

import dao.NewsDao;
import entity.News;
import utils.DBHelper;

public class NewsDaoImpl implements NewsDao{
private DBHelper db = new DBHelper();
	@Override
	public List<News> findNewsByPage(int start, int rows) {
		List<News> list = null; 
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,title,author,content,create_time,update_time,sm_img,la_img from news order by create_time limit ?,?");
			db.ps=db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, start);
			db.ps.setInt(2, rows);
			db.rs=db.ps.executeQuery();
			list = new ArrayList<News>();
			while(db.rs.next()) {
				News news = new News();
				news.setId(db.rs.getInt(1));
				news.setTitle(db.rs.getString(2));
				news.setAuthor(db.rs.getString(3));
				news.setContent(db.rs.getString(4));				
				news.setCreateTime(db.rs.getDate(5));
				news.setUpdateTime(db.rs.getDate(6));
				news.setSmImg(db.rs.getString(7));
				news.setLaImg(db.rs.getString(8));
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
	public int findNewsCount() {
		int flag=0;
		try {
			db.openDB();
			StringBuilder sb = new StringBuilder();
			sb.append("select count(1) from news");
			db.ps=db.con.prepareStatement(sb.toString());
			db.rs=db.ps.executeQuery();
			if(db.rs.next()) {
				flag = db.rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return flag;
	}
	@Override
	public News findNewsById(int id) {
		News news = null;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("select id,title,author,content,sm_img,la_img,type_id from news where id=? ");
			db.ps = db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			db.rs=db.ps.executeQuery();
			if(db.rs.next()) {
				news = new News();
				news.setId(db.rs.getInt(1));
				news.setTitle(db.rs.getString(2));
				news.setAuthor(db.rs.getString(3));
				news.setContent(db.rs.getString(4));
				news.setSmImg(db.rs.getString(5));
				news.setLaImg(db.rs.getString(6));
				news.setTypeId(db.rs.getInt(7));
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return news;
	}
	@Override
	public int updateNews(News news) {
		int flag = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("update news set title= ?,author= ?,content= ?,sm_Img= ?,la_Img= ?,type_Id= ? where id= ?");
			db.ps=db.con.prepareStatement(sb.toString());
			db.ps.setString(1, news.getTitle());
			db.ps.setString(2, news.getAuthor());
			db.ps.setString(3, news.getContent());
			db.ps.setString(4, news.getSmImg());
			db.ps.setString(5, news.getLaImg());
			db.ps.setInt(6, news.getTypeId());
			db.ps.setInt(7, news.getId());
			flag = db.ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return flag;
	}
	@Override
	public int delNewsById(int id) {
		int flag = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from news where id = ?");
			db.ps=db.con.prepareStatement(sb.toString());
			db.ps.setInt(1, id);
			flag = db.ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return flag;
	}
	@Override
	public int addNews(News news) {
		int flag = 0;
		try {
			db.openDB();
			StringBuffer sb = new StringBuffer();
			sb.append("insert into news (title,`desc`,author,content,create_time,sm_img,la_img,type_id) values (?,?,?,?,now(),?,?,?)");
			db.ps=db.con.prepareStatement(sb.toString());
			db.ps.setString(1, news.getTitle());
			db.ps.setString(2, news.getDesc());
			db.ps.setString(3, news.getAuthor());
			db.ps.setString(4, news.getContent());
			db.ps.setString(5, news.getSmImg());
			db.ps.setString(6, news.getLaImg());
			db.ps.setInt(7, news.getTypeId());
			flag = db.ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.closeDB();
		}
		return flag;
	}
}
