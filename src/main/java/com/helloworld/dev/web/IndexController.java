package com.helloworld.dev.web;

import com.helloworld.dev.config.oauth.LoginUser;
import com.helloworld.dev.config.oauth.dto.SessionUser;
import com.helloworld.dev.domain.posts.Posts;
import com.helloworld.dev.service.posts.PostsService;
import com.helloworld.dev.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user,@PageableDefault(size = 5) Pageable pageable){
        Page<Posts> posts = postsService.findAllDesc(pageable);
        model.addAttribute("posts",posts);
        model.addAttribute("previous",posts.getPageable().previousOrFirst().getPageNumber());
        model.addAttribute("next",posts.getPageable().next().getPageNumber());

        if (user != null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }
}
