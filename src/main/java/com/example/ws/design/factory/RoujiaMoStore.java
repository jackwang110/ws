package com.example.ws.design.factory;

public class RoujiaMoStore {
    private SimpleRouJiaMoFactroy factroy;

    public RoujiaMoStore(SimpleRouJiaMoFactroy factroy)
    {
        this.factroy = factroy;
    }


    public RouJiaMo sellRouJiaMo(String type)
    {
        RouJiaMo rouJiaMo = factroy.createRouJiaMo(type);
        rouJiaMo.prepare();
        rouJiaMo.fire();
        rouJiaMo.pack();
        return rouJiaMo;



    }

}
