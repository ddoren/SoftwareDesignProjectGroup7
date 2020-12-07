package softwaredesign.sdproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softwaredesign.sdproject.model.Article;
import softwaredesign.sdproject.model.User;
import softwaredesign.sdproject.repository.ArticleRepository;
import softwaredesign.sdproject.repository.UserRepository;

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
        model.addAttribute("user", UserController.modelUser());

        return "/ShowArticles.html";
    }

    //This is the html button for the "About" subpage
    @GetMapping("/about")
    public String getAbout(Model model){
        model.addAttribute("user", UserController.modelUser());

        return "/about";
    }

    //This is the html button for the "Create Article" subpage
    @GetMapping("/CreateArticle")
    public String getArticleCreateForm(Model model){
        model.addAttribute("user",UserController.modelUser());
        return "/CreateArticle";
    }

    //This is the html button "HOME"
    @GetMapping({"","/","/index","/index.html"})
    public String getIndex(Model model){
        model.addAttribute("user", UserController.modelUser());
        return "/index";
    }

    //This is to redirect to ModifyArticle page
    @GetMapping("/ModifyArticle/{articleId}")
    public String getModify(Model model, @PathVariable("articleId")int articleId){
        model.addAttribute("user",UserController.modelUser());
        model.addAttribute("article", articleRepository.findById(articleId).get());
        return "/ModifyArticle";
    }

    //Create Article
    @PostMapping("/addArticle")
    public String addUser(@ModelAttribute Article _article) {
        articleRepository.save(_article);
        return "redirect:/articles";
    }

    //Delete Article by ID
    @GetMapping("/deleteArticle/{articleId}")
    public String deleteArticle(@PathVariable("articleId") int articleId) {
        articleRepository.deleteById(articleId);
        return "redirect:/articles";
    }

    //Update Article by ID
    @PostMapping("/updateArticle")
    public String updateArticle( @ModelAttribute Article article) {
        Article _article = article;
        articleRepository.save(_article);
        return "redirect:/articles";
    }

}
