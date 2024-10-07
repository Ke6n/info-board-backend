package com.info_board.controller;

import com.info_board.pojo.Article;
import com.info_board.pojo.PageBean;
import com.info_board.pojo.Result;
import com.info_board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info-article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result<String> add(@RequestBody @Validated Article article){
        articleService.add(article);
        return  Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) String state){
        PageBean<Article> articleList = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(articleList);
    }
}