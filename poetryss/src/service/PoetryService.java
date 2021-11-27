package service;
import entity.PageBean;
import entity.Poetry;

/**
 * @author y
 */
public interface PoetryService {
    /**
     * 查询诗词表里面的所有信息
     * @param currentPage 当前页
     * @param rows  每页显示的记录条数
     * @return
     */
    PageBean<Poetry> findAllPoetry(int currentPage, int rows);

    /**
     * 根据id查询古诗信息
     * @param id
     * @return
     */
    Poetry findPoetryById(int id);

    /**
     * 根据id删除古诗信息
     * @param id
     * @return
     */
    int deletePoetryById(int id);
    /**
     * 添加诗词信息
     * @param poetry
     * @return
     */
    int addPoetry(Poetry poetry);
    /**
     * 根据id修改诗词信息
     * @param poetry
     * @return
     */
    int updatePoetry(Poetry poetry);

    /**
     *
     * @param ids
     */
    void delSelectedPoetry(String[] ids);
}
