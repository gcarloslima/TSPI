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

import com.letoshi.pagina.domain.PostComment;
import com.letoshi.pagina.service.PostCommentService;

@RestController
@RequestMapping("/postComment")
public class PostCommentController {

        @Autowired
        private PostCommentService postService;

        @GetMapping
        public List<PostComment> getAll() {
                List<PostComment> items = postService.getAll();
                return items;
        }

        @GetMapping("{id}")
        public PostComment getById(@PathVariable("id") Long id) {
                return postService.getById(id);
        }

        @PostMapping
        public PostComment create(@RequestBody PostComment item) {
                PostComment post = postService.create(item);
                return post;
        }

        @PutMapping("{id}")
        public PostComment update(@PathVariable("id") Long id, @RequestBody PostComment item) {
                return postService.update(id, item);
        }

        @DeleteMapping("{id}")
        public boolean delete(@PathVariable("id") Long id) {
                return postService.delete(id);
        }
}