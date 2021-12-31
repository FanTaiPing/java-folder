import com.fan.dao.TeacherMapper;
import com.fan.entity.Teacher;
import com.fan.utils.DBHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestTeacher {
    private SqlSession sqlSession;

    @Test
    public void testGetTeacherById() {
        try {
            sqlSession = DBHelper.openDB();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = teacherMapper.getTeacherById(1);
            System.out.println(teacher);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            DBHelper.closeDB();
        }
    }
}
