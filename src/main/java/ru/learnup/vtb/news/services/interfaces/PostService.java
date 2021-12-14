package ru.learnup.vtb.news.services.interfaces;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */
public interface PostService {

    void create(String title, String text);
    void delete(int id);
    void update(int id, String title, String text);
    void print(int id);
    void print();
}
