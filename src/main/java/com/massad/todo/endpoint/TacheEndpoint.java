package com.massad.todo.endpoint;
import com.massad.soap.AddTacheRequest;
import com.massad.soap.AddTacheResponse;
import com.massad.soap.GetTacheRequest;
import com.massad.soap.GetTacheResponse;
import com.massad.todo.domaine.Tache;
import com.massad.todo.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.Optional;

@Endpoint
public class TacheEndpoint {

    @Autowired
    public TacheService tacheService;

    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "getTacheRequest")
    @ResponsePayload
    public GetTacheResponse getTacheRequest(@RequestPayload GetTacheRequest request){
        GetTacheResponse getTacheResponse = new GetTacheResponse();
        Optional<Tache> t = tacheService.getTachebyId(request.getId());
        com.massad.soap.Tache ts = new com.massad.soap.Tache();

        if(t.isPresent()){
            ts.setId(t.get().id);
            ts.setTitre(t.get().titre);
            ts.setMessage(t.get().message);
            ts.setActivated(t.get().activated);
            ts.setDescription(t.get().description);
        }

        getTacheResponse.setTache(ts);
        return getTacheResponse;
    }

    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
            localPart = "addTacheRequest")
    @ResponsePayload
    public AddTacheResponse addTacheResponse(@RequestPayload AddTacheRequest request){
        AddTacheResponse addTacheResponse = new AddTacheResponse();
        Tache t = new Tache();
        t.setTitre(request.getTache().getTitre());
        t.setDescription(request.getTache().getDescription());
        t.setMessage(request.getTache().getMessage());
        t.setActivated(request.getTache().isActivated());
        Tache rt = tacheService.createTache(t);
        com.massad.soap.Tache ro = new com.massad.soap.Tache();
        ro.setId(rt.id);
        ro.setTitre(rt.titre);
        ro.setDescription(rt.description);
        ro.setMessage(rt.message);
        ro.setActivated(rt.activated);
        addTacheResponse.setTache(ro);
        return addTacheResponse;
    }


}
