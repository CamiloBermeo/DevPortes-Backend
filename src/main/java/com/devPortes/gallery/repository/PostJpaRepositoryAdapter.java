package com.devPortes.gallery.repository;


import com.devPortes.gallery.entities.PostEntity;
import com.devPortes.gallery.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostJpaRepositoryAdapter {
    private final IPostJpaRepository jpa;

    public List<Post> findAll(){
        List<PostEntity> savePosts = jpa.findAll();
        return PostOutMapper.toModelList(savePosts);
    }


}
