package ru.learnup.vtb.news.repositories.interfaces;

import ru.learnup.vtb.news.entities.PostEntity;

import java.util.Collection;
import java.util.List;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */
public interface PostRepository {

    PostEntity get(int id);
    Collection<PostEntity> get();
    void create(PostEntity postEntity);
    void update(PostEntity postEntity);
    void delete(int id);
}
