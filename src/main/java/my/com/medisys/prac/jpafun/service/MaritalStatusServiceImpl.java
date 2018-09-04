package my.com.medisys.prac.jpafun.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.com.medisys.prac.jpafun.entity.MaritalStatus;
import my.com.medisys.prac.jpafun.repository.MaritalStatusRepository;

/**
 * @author    Medisys<devs@medisys.com.my>
 * @version   0.0.00.GA
 * @since     0.0.00.GA
 */
@Service
public class MaritalStatusServiceImpl implements MaritalStatusService{

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(MaritalStatusServiceImpl.class);

    @Autowired
    MaritalStatusRepository repo;

    @Override
    public List<MaritalStatus> findAll(){
        return repo.findAll();
    }

    @Override
    public MaritalStatus findByMaritalStatusCode(String maritalStatusCode){
        return repo.findByMaritalStatusCode(maritalStatusCode);
    }

}
