package me.leeminjeong.springbootdeveloper.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.leeminjeong.springbootdeveloper.domain.Article;
import me.leeminjeong.springbootdeveloper.dto.AddArticleRequest;
import me.leeminjeong.springbootdeveloper.dto.UpdateArticleRequest;
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

    public Article findById(long id){
        return blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));
    }

    public void deleteById(long id){
        blogRepository.deleteById(id);
    }

    @Transactional // 매칭한 메서드를 하나의 트랜잭션으로 묶는 역할
    public Article update(long id, UpdateArticleRequest request){
        Article article = blogRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("not found: "+id));

        article.update(request.getTitle(), request.getContent());

        return article;
    }
}
