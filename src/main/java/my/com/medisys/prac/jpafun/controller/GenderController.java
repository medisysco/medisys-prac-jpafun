package my.com.medisys.prac.jpafun.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import my.com.medisys.prac.jpafun.entity.Gender;
import my.com.medisys.prac.jpafun.service.GenderService;

@RestController
@RequestMapping("/gender")
public class GenderController {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(GenderController.class);

    @Autowired
    GenderService service;

    @GetMapping
    public Map<String, Object> findAll() {
        Map<String, Object> res = new HashMap<String, Object>();
        List<Gender> genders = service.findAll();
        String message = CollectionUtils.isEmpty(genders) ? "No Record Found" : "Records Found";
        res.put("message", message);
        res.put("data", genders);
        res.put("success", true);
        return res;
    }

    @GetMapping("/{genderCode}")
    public Map<String, Object> findByGenderCode(@PathVariable("genderCode") String genderCode) {
        Map<String, Object> res = new HashMap<String, Object>();
        Gender gender = service.findByGenderCode(genderCode);
        String message = ObjectUtils.isEmpty(gender) ? "No Record Found" : "One Record Found";
        res.put("message", message);
        res.put("success", true);
        res.put("data", gender);
        return res;
    }

}
