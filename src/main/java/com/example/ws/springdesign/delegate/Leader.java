package com.example.ws.springdesign.delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmplotee{
    private Map<String, IEmplotee> map =  new HashMap<String, IEmplotee>();
    public Leader(){
        map.put("加密",new IEmployeeA());
        map.put("解密",new IEmployeeB());
    }
    @Override
    public void doing(String command) {
        map.get(command).doing(command);

    }

}
