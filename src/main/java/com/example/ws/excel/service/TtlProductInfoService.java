package com.example.ws.excel.service;


import com.example.ws.excel.TtlProductInfoPo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author kundy
 * @create 2019/2/16 11:22 AM
 */
public interface TtlProductInfoService {

    List<TtlProductInfoPo> listProduct(Map<String, Object> map);

    void export(HttpServletResponse response, String fileName);

}
