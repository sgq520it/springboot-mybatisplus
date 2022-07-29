package com.sgq.xcx.Controller;


import com.sgq.xcx.Entity.Article;
import com.sgq.xcx.Entity.ArticleWithUser;
import com.sgq.xcx.Entity.BasePoJo.Response;
import com.sgq.xcx.Entity.RequestPoJo.ArticleReq;
import com.sgq.xcx.Service.ArticleService;
import com.sgq.xcx.Utils.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "/getAllArticle")
    public Response getAllArticle(){
        log.info("请求getAllArticle开始");
        List<Article> allArticle = articleService.getAllArticle();
        allArticle.stream().forEach(item->
                {
                    item.setCreatetime(TimeUtil.changeTime(new Integer(item.getCreatetime())));
                    if(item.getContent().length()>42){
                        item.setContent(item.getContent().substring(0,41)+"....");
                    }
                }
        );
        log.info("返回数据"+allArticle.toString());
        Response response = new Response();
        if(allArticle != null){
            response.setCode("200");
            response.setMsg("查询所有文章成功");
            response.setData(allArticle);
        }else {
            response.setCode("999999");
            response.setMsg("查询所有文章失败");
        }
        return  response;
    }

    @PostMapping(value = "/addArticle")
    public Response addArticle(@RequestBody ArticleReq param){
        log.info("发布文章处理开始");
        log.info("入参："+param.toString());
        Article article = Article.builder().title(param.getTitle()).content(param.getContent()).imgurl("/images/cat.jpg").openid(param.getOpenid()).build();
        int i = articleService.addArticle(article);
        Response response = Response.builder().code("200").msg("创建帖子成功").data(i).build();
        log.info("发布文章响应参数："+response.toString());
        return  response;
    }

    @PostMapping(value = "/getArticleLike")
    public Response getArticleLike(@RequestBody ArticleReq param){
        log.info("搜索查询开始");
        log.info("查询参数"+param.getContent());
        List<Article> articleLike = articleService.getArticleLike(param.getContent());
        Response build = Response.builder().data(articleLike).msg("搜索查询成功").code("200").build();
        log.info("搜索查询响应参数："+build.toString());
        return build;

    }
    @PostMapping(value = "/getArticleDetail")
    public Response getArticleDetail(@RequestBody ArticleReq param){
        log.info("获取帖子详情开始");
        log.info("入参："+param.getId());
        ArticleWithUser articleDetail = articleService.getArticleDetail(param.getId());
        Response resp = Response.builder().code("200").msg("获取帖子详情成功").data(articleDetail).build();
        return resp;

    };

}
