package com.cognitech.springboot_docker_compose.repo;

import com.cognitech.springboot_docker_compose.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
}
