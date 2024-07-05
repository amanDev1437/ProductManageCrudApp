package springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;
import springmvc.dao.ProductDao;
import springmvc.model.Product;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/home")
    public String home(Model model, HttpSession session){

        if(session.getAttribute("id")!=null){
            List<Product> productList = productDao.getAllProduct();
            model.addAttribute("product",productList);
            return "home";
        }
        model.addAttribute("message","please login first");
        return "login";

    }

    @RequestMapping("/addProduct")
    public String addProduct(Model model, HttpSession session){

        if(session.getAttribute("id")!=null){
            return "addProduct";
        }

        model.addAttribute("message","please login first");
        return "login";

    }

    @RequestMapping(value = "/handleProduct",method = RequestMethod.POST)
    public RedirectView handleProduct(@ModelAttribute Product product){
        productDao.createProduct(product);
        return new RedirectView("/home");
    }

    @RequestMapping("/delete/{productId}")
    public RedirectView deleteProduct(@PathVariable("productId") int id){
        productDao.deleteProduct(id);
        return new RedirectView("/home");
    }

    @RequestMapping("/update/{productId}")
    public String updateProduct(@PathVariable("productId") int id, Model model,HttpSession session){

        if(session.getAttribute("id")!=null){
            model.addAttribute("product",productDao.getProduct(id));
            return "updateProduct";
        }
        model.addAttribute("message","please login first");
        return "login";

    }

}
