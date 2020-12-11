package softwaredesign.sdproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softwaredesign.sdproject.model.Article;
import softwaredesign.sdproject.model.Comment;
import softwaredesign.sdproject.model.User;
import softwaredesign.sdproject.repository.ArticleRepository;
import softwaredesign.sdproject.repository.CommentRepository;
import softwaredesign.sdproject.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    //Show All Articles
    @GetMapping("/articles")
    public String getAllArticles(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("articlesTech", articleRepository.findByCategoryContaining("Tech"));
        model.addAttribute("articlesModelling",articleRepository.findByCategoryContaining("Modelling"));
        model.addAttribute("user", UserController.modelUser());

        return "/ShowArticles";
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

    @GetMapping("/viewOne/{articleId}")
    public String viewOne(@PathVariable("articleId") int articleId,Model model){
        model.addAttribute("user",UserController.modelUser());
        model.addAttribute("article",articleRepository.getOne(articleId));
        List<Comment> commentList= commentRepository.findCommentsByArticleId(articleId);

        User[] user =new User[commentList.size()];
        for(int i=0;i<commentList.size();i++) {
           user[i]=userRepository.getOne(commentList.get(i).getUserId());
        }
        model.addAttribute("userList",user);
        model.addAttribute("comments",commentList);
        return "/viewOne";
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
    //REVERSE THE ARTICLES
    //Show Articles by Category
    @GetMapping("/articles/{category}")
    public String getAllArticlesByCategory(@PathVariable String category, Model model) {
        List<Article> _articleList = articleRepository.findByCategoryContaining(category);
        model.addAttribute("articles", _articleList);
        model.addAttribute("user", UserController.modelUser());
        return "/ShowArticles";
    }
    @PostMapping("/postComment")
    public String postComment(@ModelAttribute("comment") String commentText,@ModelAttribute("articleId") int articleId,@ModelAttribute("user") User user){
        Comment comment=new Comment();
        comment.setArticleId(articleId);
        comment.setComment(commentText);
        comment.setUserId(user.getUserId());

    commentRepository.save(comment);
    return "redirect:/index";
    }
    @GetMapping("/viewProfile")
    public String viewProfile(Model model){
        model.addAttribute("userList",userRepository.findAll());
        model.addAttribute("user",UserController.modelUser());
        return "viewProfile";
    }

    @GetMapping("/deleteComment/{commentId}")
    public String deleteComment(@PathVariable("commentId") int commentId){
        int articleId=commentRepository.getOne(commentId).getArticleId();
        commentRepository.delete(commentRepository.getOne(commentId));
        return "redirect:/viewOne/"+articleId+"";
    }

}
