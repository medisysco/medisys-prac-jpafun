package my.com.medisys.prac.jpafun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.com.medisys.prac.jpafun.entity.Gender;
import my.com.medisys.prac.jpafun.repository.GenderRepository;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Service
public class GenderServiceImpl implements GenderService{

    @Autowired
    GenderRepository repo;

    @Override
    public List<Gender> findAll(){
        return repo.findAll();
    }

    @Override
    public Gender findByGenderCode(String genderCode){
        return repo.findByGenderCode(genderCode);
    }

}
