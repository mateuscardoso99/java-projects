package com.simple_crud_spring_boot.spring_boot_simple_crud.repositories;

import com.simple_crud_spring_boot.spring_boot_simple_crud.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //repositorio de dados, para interagir com o banco

public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
