package my.com.medisys.prac.javaee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.com.medisys.prac.javaee.entity.Nationality;
import my.com.medisys.prac.javaee.repository.NationalityRepository;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Service
public class NationalityServiceImpl implements NationalityService{

    @Autowired
    NationalityRepository repo;

    public List<Nationality> findAll(){
        return repo.findAll();
    }

    public Nationality findByNationalityCode(String nationalityCode){
        return repo.findByNationalityCode(nationalityCode);
        //return repo.findOne(nationalityCode);
    }

}
