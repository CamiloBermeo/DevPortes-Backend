package com.devPortes.gallery.repository;


import com.devPortes.gallery.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostJpaRepository extends JpaRepository<PostEntity, Long> {
}
