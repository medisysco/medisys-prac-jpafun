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

import my.com.medisys.prac.jpafun.entity.MaritalStatus;
import my.com.medisys.prac.jpafun.service.MaritalStatusService;

@RestController
@RequestMapping("/marital/status")
public class MaritalStatusContoller {

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(MaritalStatusContoller.class);

    @Autowired
    MaritalStatusService service;

    @GetMapping
    public Map<String, Object> findAll() {
        Map<String, Object> res = new HashMap<String, Object>();
        List<MaritalStatus> list = service.findAll();
        String message = CollectionUtils.isEmpty(list) ? "No Record Found" : "Records Found";
        res.put("message", message);
        res.put("success", true);
        res.put("data", list);
        return res;
    }

    @GetMapping("/{maritalStatusCode}")
    public Map<String, Object> findByMaritalStatusCode(@PathVariable(value = "maritalStatusCode") String maritalStatusCode) {
        Map<String, Object> res = new HashMap<String, Object>();
        MaritalStatus maritalStatus = service.findByMaritalStatusCode(maritalStatusCode);
        String message = ObjectUtils.isEmpty(maritalStatus) ? "No Record Found" : "One Record Found";
        res.put("data", maritalStatus);
        res.put("message", message);
        res.put("success", true);
        return res;
    }

}
