package com.devPortes.gallery.mapper;

import com.devPortes.gallery.dto.NewPostRequestDto;
import com.devPortes.gallery.model.Post;

import java.util.List;

public class PostInMapper {
    public static Post toModel(NewPostRequestDto dto, List<String> urlPictures){
        return Post.create(
                dto.name(),
                dto.description(),
                urlPictures,
                dto.eventDate()
        );
    }
}
