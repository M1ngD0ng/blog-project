package me.leeminjeong.springbootdeveloper.repository;

import me.leeminjeong.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
