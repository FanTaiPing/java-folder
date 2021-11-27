package utils;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author ljsy
 **/
public class DBHelper {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

    /**
     * @param index 字段序号
     * @return rs.getInt();
     */
    public int getInt(int index) {
        try {
            return rs.getInt(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * @param index 字段序号
     * @return rs.getString();
     */
    public String getString(int index) {
        try {
            return rs.getString(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param index 字段序号
     * @return rs.getDate();
     */
    public Date getDate(int index) {
        try {
            return rs.getDate(index);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 判断结果集rs中是否有下一个值, 为false时将关闭数据库连接
     *
     * @return ResultSet.next();
     */
    public boolean next() {
        try {
            if (rs.next()) {
                return true;
            } else {
                close();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 连接数据库并执行更新sql语句, 结果放在rs中, 调用DBHelper.next()为false时将关闭数据库连接
     *
     * @param sql       执行更新的sql语句
     * @param sqlValues sql语句中对应的值
     */
    public void executeQuery(String sql, List<Object> sqlValues) {
        try {
            ps = getPs(sql, sqlValues);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库并执行更新sql语句, 结果放在rs中, 调用DBHelper.next()为false时将关闭数据库连接
     *
     * @param sql 执行更新的sql语句
     */
    public void executeQuery(String sql) {
        try {
            open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接数据库并执行更新sql语句, 最后关闭数据库连接
     *
     * @param sql       执行更新的sql语句
     * @param sqlValues sql语句中对应的值
     * @return 受影响的行数
     */
    public int executeUpdate(String sql, List<Object> sqlValues) {
        try {
            ps = getPs(sql, sqlValues);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return 0;
    }

    private PreparedStatement getPs(String sql, List<Object> sqlValues) throws SQLException {
        open();
        PreparedStatement ps = con.prepareStatement(sql);
        int i = 1;
        for (Object value : sqlValues) {
            ps.setObject(i, value);
            i++;
        }
        return ps;
    }

    private void open() {
        String driver = resourceBundle.getString("driver");
        String url = resourceBundle.getString("url");
        String username = resourceBundle.getString("username");
        String password = resourceBundle.getString("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
