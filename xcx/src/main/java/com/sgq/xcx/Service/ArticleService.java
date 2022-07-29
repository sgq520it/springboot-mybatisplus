package com.sgq.xcx.Service;

import com.sgq.xcx.Entity.Article;
import com.sgq.xcx.Entity.ArticleWithUser;
import com.sgq.xcx.Mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    public ArticleWithUser getArticleDetail(String id) {
        return articleMapper.getArticleDetail(id);
    }

    public List<Article> getArticleLike(String param) {
        return articleMapper.getArticleLike(param);
    }

    public  List<Article> getAllArticle() {

        return articleMapper.getAllArticle();
    }

    public int addArticle(Article article) {
        return articleMapper.addArticle(article);
    }
}
