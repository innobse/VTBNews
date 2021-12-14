package ru.learnup.vtb.news;

import ru.learnup.vtb.news.repositories.PostRepositoryImpl;
import ru.learnup.vtb.news.services.PostServiceImpl;
import ru.learnup.vtb.news.services.interfaces.PostService;

/**
 * Description
 *
 * @author bse71
 * Created on 14.12.2021
 * @since
 */
public class Main {

    public static void main(String[] args) {

        PostService postService = new PostServiceImpl(
                new PostRepositoryImpl());

//        postService.create("14 декабря", "Какой-то текст в 20:42");
        postService.print();

    }
}
