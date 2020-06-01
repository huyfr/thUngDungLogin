package controller;

import model.Login;
import model.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

@Controller
public class UserController {

    private static Logger logger = LogManager.getLogger(UserController.class);

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView loadIndex(Model model) {
        logger.trace("Vao loadIndex");
        ModelAndView index = new ModelAndView("index");
        model.addAttribute("login", new Login());
        logger.trace("Thoat loadIndex");
        return index;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loadLogin(@ModelAttribute("login") Login login) {
        logger.trace("Vao loadLogin");
        User user = UserService.checkLogin(login);
        if (user == null) {
            ModelAndView loadError = new ModelAndView("error");
            logger.info("Sang trang error.jsp");
            logger.trace("Thoat loadLogin");
            return loadError;
        } else {
            ModelAndView loadUser = new ModelAndView("user");
            loadUser.addObject("user", user);
            logger.info("Sang trang user.jsp");
            logger.trace("Thoat loadLogin");
            return loadUser;
        }
    }
}
