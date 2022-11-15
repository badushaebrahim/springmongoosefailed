package training.acabes.interservicecommunication.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import training.acabes.interservicecommunication.model.request.Requestmodel;
import training.acabes.interservicecommunication.model.responce.MsgModel;
import training.acabes.interservicecommunication.model.responce.ResponceModel;
import training.acabes.interservicecommunication.service.CommunicationService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/con")
public class CommunicationController {
    @Autowired
    CommunicationService communicationService;

    @PostMapping
    public ResponseEntity<ResponceModel> add(@RequestBody Requestmodel requestmodel){
        return new ResponseEntity<>(communicationService.creates(requestmodel), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ResponceModel>> get(){
        List<ResponceModel> data = communicationService.getAll();
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<ResponceModel> putendpoint(@RequestBody ResponceModel responceModel){
        return new ResponseEntity<>(communicationService.put(responceModel), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MsgModel> putendpoint(@PathVariable String id){
        return new ResponseEntity<>(communicationService.delete(id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponceModel> getbyidendpoint(@PathVariable String id){
        log.info(id);
        return new ResponseEntity<>(communicationService.getbyid(id), HttpStatus.CREATED);
    }


}
