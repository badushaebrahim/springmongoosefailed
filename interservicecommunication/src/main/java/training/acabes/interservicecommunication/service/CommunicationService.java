package training.acabes.interservicecommunication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import training.acabes.interservicecommunication.model.request.Requestmodel;
import training.acabes.interservicecommunication.model.responce.MsgModel;
import training.acabes.interservicecommunication.model.responce.ResponceModel;

import java.util.List;

@Service
public class CommunicationService {


   @Autowired
   CommuninactionInterface communinactioninterface;

   public ResponceModel creates(Requestmodel requestmodel){
       return communinactioninterface.create(requestmodel);
   }

   public List<ResponceModel> getAll(){
       List<ResponceModel> data = communinactioninterface.get();
       return data;
   }
    public ResponceModel put(ResponceModel responceModel){
        return communinactioninterface.put(responceModel);
    }

    public MsgModel delete(String id){
       return communinactioninterface.delete(id);
    }
    public  ResponceModel getbyid(String id){
       return communinactioninterface.getbyid(id);
    }
}
