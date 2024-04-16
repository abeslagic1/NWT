package com.etf.service;

import com.etf.exceptions.NotFoundException;
import com.etf.model.Pacijent;
import com.etf.repository.PacijentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PacijentService {

    @Autowired
    private PacijentRepository pacijentRepository;

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    private List<Pacijent> recoveryListaPacijenata;

//    @Value("${spring.rabbitmq.template.exchange}")
//    private String exchange;
//
//    @Value("${spring.rabbitmq.template.routing-key}")
//    private String routingKey;



    public Iterable<Pacijent> savePatients(List<Pacijent> patients){
        return pacijentRepository.saveAll(patients);
    }

    public Iterable<Pacijent> getPatients(){
        Iterable<Pacijent> patients = pacijentRepository.findAll();
        return patients;
    }

//    public Pacijent getPatientById(int id) {
//        Pacijent p = pacijentRepository.findById(id);
//
//        if(p == null){
//            throw new NotFoundException("Patient with id = " + id + "does not exist.");
//        }
//        return p;
//    }

//    public String deletePatient(int id){
//        Pacijent pacijent = pacijentRepository.findById(id);
//
//        if(pacijent == null){
//            throw new NotFoundException("Patient with id = " + id + " does not exist.");
//        }
//        recoveryListaPacijenata.add(pacijent);
//        pacijentRepository.deleteById(id);
//        return "Patient removed";
//    }

    public Pacijent getPatientByName(String ime){
        Pacijent pacijenti = pacijentRepository.findByIme(ime);
        return pacijenti;
    }
}
