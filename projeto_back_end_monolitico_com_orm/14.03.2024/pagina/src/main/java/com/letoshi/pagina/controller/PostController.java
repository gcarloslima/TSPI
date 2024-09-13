package com.letoshi.pagina.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letoshi.pagina.domain.Post;
import com.letoshi.pagina.domain.PostComment;
import com.letoshi.pagina.service.PostCommentService;
import com.letoshi.pagina.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

        @Autowired
        private PostService postService;

        @Autowired
        private PostCommentService postCommentService;

        @GetMapping
        public List<Post> getAll() {
                List<Post> items = postService.getAll();
                return items;
        }

        @GetMapping("{id}")
        public Post getById(@PathVariable("id") Long id) {
                return postService.getById(id);
        }

        @PostMapping
        public Post create(@RequestBody Post item) {
                Post postComment = postService.create(item);
                return postComment;
        }

        @PutMapping("{id}")
        public Post update(@PathVariable("id") Long id, @RequestBody Post item) {
                return postService.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return postService.delete(id);
        }

        @PostMapping("/{id}/comments")
        public PostComment addComment(@PathVariable Long id, @RequestBody PostComment comment) {
                Post post = postService.getById(id);
                post.addComment(comment);
                postService.create(post);
                return comment;
        }

        @DeleteMapping("/{postId}/comments/{commentId}")
        public Post removeComment(@PathVariable Long postId, @PathVariable Long commentId) {
                Post post = postService.getById(postId);
                PostComment comment = postCommentService.getById(commentId);
                post.removeComment(comment);
                postService.create(post);
                return post;
        }

}