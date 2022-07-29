package com.sgq.xcx.Mapper;

import com.sgq.xcx.Entity.Article;
import com.sgq.xcx.Entity.ArticleWithUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Select("SELECT id," +
            "            title," +
            "            content," +
            "            imgurl," +
            "            openid," +
            "            TIMESTAMPDIFF(MINUTE,createtime,CURRENT_TIMESTAMP) as createtime" +
            "            FROM article ORDER BY createtime DESC")
   List<Article> getAllArticle ();

    @Insert("INSERT INTO article (title,content,imgurl,openid,createtime) values(#{title},#{content},#{imgurl},#{openid},CURRENT_TIMESTAMP)")
    int addArticle(Article article);

    @Select("SELECT * FROM article")
    List<Article> getArticleLike(String str);

    @Select("select DISTINCT a.id, title, content,imgurl,a.openid,SUBSTR(createtime,1,19) as createtime,u.nickname from article a , user u where u.openid = a.openid and  a.id =#{id}")
    ArticleWithUser getArticleDetail(String id);
}
