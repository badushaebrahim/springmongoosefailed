package training.acabes.interservicecommunication.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import training.acabes.interservicecommunication.model.request.Requestmodel;
import training.acabes.interservicecommunication.model.responce.MsgModel;
import training.acabes.interservicecommunication.model.responce.ResponceModel;

import java.util.List;

@FeignClient(name = "Employee", url = "${config.rest.service.addStudentUrl}")
public interface CommuninactionInterface {

    @PostMapping
    public ResponceModel create(@RequestBody Requestmodel requestmodel);

    @GetMapping
    public List<ResponceModel> get();

    @PutMapping
    public ResponceModel put(@RequestBody ResponceModel responceModel);

    @DeleteMapping()
    public MsgModel delete(@RequestParam String id);

    @GetMapping("/{id}")
    public ResponceModel getbyid(String id);


}
