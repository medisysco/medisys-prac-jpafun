package my.com.medisys.prac.javaee.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author    Shahed Hossain<shahed@medisys.com.sa>
 * @version   3.0.00
 * @since     2.0.00
 */
@Controller
@RequestMapping("/")
public class DefaultController {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(DefaultController.class);
    public static final String BASE_URL = "http://localhost:9090";

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index(Locale locale) throws IOException {
        return new ModelAndView(String.format("redirect:%s", "/en/"));
    }

    @RequestMapping(value = "/{lang:[ar|en]{2}}", method = RequestMethod.GET)
    public ModelAndView switcher(@PathVariable String lang, Locale locale) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("title", "Medical Systems Co. Limited");
        parameters.put("maritalStatus", getBashCommand("marital/status", "M"));
        parameters.put("nationality", getBashCommand("nationality", "BGD"));
        parameters.put("patient", getBashCommand("patient", "100001"));
        parameters.put("gender", getBashCommand("gender", "M"));
        return new ModelAndView("views/welcome", parameters);
    }

    private String getBashCommand(String name, String id) {
        String bash = "\n";
        bash += String.format("bash <(curl -s   '%s/%s'\n", BASE_URL, name);
        bash += String.format("bash <(wget -qO- '%s/%s'\n\n", BASE_URL, name);
        bash += String.format("bash <(curl -s   '%s/%s/%s'\n", BASE_URL, name, id);
        bash += String.format("bash <(wget -qO- '%s/%s/%s'\n", BASE_URL, name, id);
        return bash;
    }

}
