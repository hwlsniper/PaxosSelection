package com.luairan.service.paxoslease;

import com.luairan.service.context.Request;
import com.luairan.service.context.Response;
import com.luairan.service.context.Type;
import com.luairan.service.http.HTTPClient;

public class ProposerOne implements Runnable {
    private String url;
    private Proposer proposer;
    private Request request;

    public ProposerOne(String url, Proposer proposer, Request request) {
        this.url = url;
        this.proposer = proposer;
        this.request = request;
    }

    @Override
    public void run() {
        Response response = (Response) HTTPClient.sendPost(url,new ProposeAction(), request);
        if (response.getType() == Type.Closed)
            return;
        proposer.reciveResponseOne(response);
    }

}



