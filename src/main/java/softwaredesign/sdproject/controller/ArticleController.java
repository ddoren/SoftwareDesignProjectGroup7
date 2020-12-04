package softwaredesign.sdproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softwaredesign.sdproject.model.Article;
import softwaredesign.sdproject.repository.ArticleRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;

    //Show All Articles
    @GetMapping("/articles")
    public String getAllArticles(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articles", articleList);
        return "/ShowArticles.html";
    }

    //This is the html button for the "About" subpage
    @GetMapping("/about")
    public String getAbout(){
        return "/about";
    }

    //This is the html button for the "Create Article" subpage
    @GetMapping("/CreateArticle")
    public String getArticleCreateForm(){
        return "/CreateArticle";
    }

    //This is the html button "HOME"
    @GetMapping("/index")
    public String getIndex(){
        return "/index";
    }

    //Create Article
    @PostMapping("/addArticle")
    public String addUser(@ModelAttribute Article _article) {
        articleRepository.save(_article);
        return "/ShowArticles";
    }

    //Delete Article by ID
    @DeleteMapping("/deleteArticle")
    public String deleteArticle(@PathVariable("articleId") int articleId) {
        articleRepository.deleteById(articleId);
        return "/ShowArticles";
    }

    //Update Article by ID
    @PutMapping("/updateArticle")
    public String updateArticle(@PathVariable("articleId") int articleId, @RequestBody Article article) {
        Optional<Article> articleData = articleRepository.findById(articleId);
        Article _article = articleData.get();
        _article.setCategory(article.getCategory());
        _article.setTitle(article.getTitle());
        _article.setBody(article.getBody());
        articleRepository.save(_article);
        return "/ShowArticles";

    }

}
