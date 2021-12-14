package ru.learnup.vtb.news.services;

import ru.learnup.vtb.news.entities.PostEntity;
import ru.learnup.vtb.news.repositories.interfaces.PostRepository;
import ru.learnup.vtb.news.services.interfaces.PostService;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void create(String title, String text) {
        postRepository.create(
                new PostEntity(title, text));
    }

    public void delete(int id) {
        postRepository.delete(id);
    }

    public void update(int id, String title, String text) {
        postRepository.update(
                new PostEntity(id, title, text));
    }

    public void print(int id) {
        System.out.println(
                postRepository.get(id));
    }

    public void print() {
        System.out.println(
                postRepository.get());
    }
}
