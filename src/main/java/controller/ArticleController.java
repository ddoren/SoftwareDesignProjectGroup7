package controller;


import model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import repository.ArticleRepository;
import repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CommentRepository commentRepository;

    //All Articles
    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles(@RequestParam(required = false) String id) {
        List<Article> articles = new ArrayList<>();
        articles = articleRepository.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }


}
