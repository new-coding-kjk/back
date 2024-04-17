package com.roulette.roulette.post.controller;

import com.roulette.roulette.post.dto.*;
import com.roulette.roulette.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/code")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/{page}")
    public Page<PostListDto> getPostList(@PathVariable int page) {
        return postService.getRecentPosts(page, 10);
    }

    @GetMapping("/{post_id}")
    public PostDto getPost(@PathVariable Long post_id) {
        return postService.getPostById(post_id).get(); //Optional로 주기 때문에

    }

    @PostMapping("/choice")
    public ResponseEntity<Void> chooseReply(@RequestBody ChooseRequestDto request) {
        postService.setPostChoiceComplete(request.getPostId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/ask")
    public AskPostResponseDto askPost(@RequestBody AskPostRequestDto request){
        Long postId = postService.createPost(request);
        return new AskPostResponseDto(postId);
    }
}
