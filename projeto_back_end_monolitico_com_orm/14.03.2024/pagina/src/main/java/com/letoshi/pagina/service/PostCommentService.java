package com.letoshi.pagina.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letoshi.pagina.domain.PostComment;
import com.letoshi.pagina.repository.PostCommentRepository;

@Service
public class PostCommentService {

    @Autowired
    private PostCommentRepository postCommentRepository;

    public List<PostComment> getAll() {
        try {
            List<PostComment> comments = new ArrayList<PostComment>();
            postCommentRepository.findAll().forEach(comments::add);
            return comments;
        } catch (Exception e) {
            return null;
        }
    }

    public PostComment getById(Long id) {
        Optional<PostComment> Post = postCommentRepository.findById(id);
        if (Post.isPresent()) {
            return Post.get();
        }
        return null;
    }

    public PostComment create(PostComment post) {
        return postCommentRepository.save(post);
    }

    public PostComment update(Long id, PostComment item) {
        Optional<PostComment> existingItemOptional = postCommentRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            PostComment existingItem = existingItemOptional.get();
            existingItem.setPost(item.getPost());
            existingItem.setReview(item.getReview());
            return postCommentRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            if (postCommentRepository.findById(id).isPresent()) {
                postCommentRepository.deleteById(id);
                return true;
            } else {
                return false;
            }   
        } catch (Exception e) {
            return false;
        }
    }

}
