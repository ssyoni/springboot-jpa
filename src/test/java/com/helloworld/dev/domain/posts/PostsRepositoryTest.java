package com.helloworld.dev.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void save_post(){
        //given
        String title = "test board";
        String content = "test content";

        postsRepository.save(Posts.builder().title(title).content(content).author("jsy@gmail.com").build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void insert_baseTimeEntity(){
        //given
        LocalDateTime now = LocalDateTime.of(2021,12,15,0,0,0);
        postsRepository.save(Posts.builder().title("title").content("content").author("jsy").build());

        //whebn
        List<Posts> all = postsRepository.findAll();

        //then
        Posts posts = all.get(0);

        System.out.println(">>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
