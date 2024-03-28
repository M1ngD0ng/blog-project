package me.leeminjeong.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.leeminjeong.springbootdeveloper.domain.Article;
import me.leeminjeong.springbootdeveloper.dto.AddArticleRequest;
import me.leeminjeong.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor // 빈을 생성자로 생성, final이 붙거나 @NotNull이 붙은 필드로 생성자 추가
@Service // 해당 클래스를 빈으로 등록
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save(AddArticleRequest request){ // AddArticleRequest 클래스에 저장된 값들을 article 데이터베이스에 저장ㅇ
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
}
