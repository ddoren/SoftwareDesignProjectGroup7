package softwaredesign.sdproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softwaredesign.sdproject.model.Article;
import softwaredesign.sdproject.repository.ArticleRepository;

import java.util.List;

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


    @GetMapping("/about")
    public String getAbout(){
        return "/about";}


}
