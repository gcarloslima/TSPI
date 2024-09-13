package com.letoshi.pagina.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letoshi.pagina.domain.Post;
import com.letoshi.pagina.repository.PostRepository;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAll() {
        try {
            List<Post> items = new ArrayList<Post>();
            postRepository.findAll().forEach(items::add);
            return items;
        } catch (Exception e) {
            return null;
        }
    }

    public Post getById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isPresent()) {
            return post.get();
        }
        return null;
    }

    public Post create(Post Post) {
        return postRepository.save(Post);
    }

    public Post update(Long id, Post item) {
        Optional<Post> existingItemOptional = postRepository.findById(id);

        if (existingItemOptional.isPresent()) {
            Post existingItem = existingItemOptional.get();
            existingItem.setTitle(item.getTitle());
            return postRepository.save(existingItem);
        } else {
            return null;
        }
    }

    public boolean delete(Long id) {
        try {
            if (postRepository.findById(id).isPresent()) {
                postRepository.deleteById(id);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
