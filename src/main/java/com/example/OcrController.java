package com.example;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/ocr")
@CrossOrigin(methods = { RequestMethod.GET, RequestMethod.POST }, origins = "*")
public class OcrController {

    @RequestMapping(value = "/go",method = RequestMethod.POST)
    public List<Object> go(HttpServletRequest request, HttpServletResponse response,String base64Url) throws IOException {
        // 设置可跨域请求
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        BASE64Decoder encoder = new BASE64Decoder();
        // 将base64编码进行解码
        byte[] encoderUrl = encoder.decodeBuffer(base64Url);
        // 百度ocr请求参数
        AipOcr client = new AipOcr("15775182","cXdqP7wsHNzQGOo79G08X98I","O4VNCvG989fEhxvMEf9bqnyDrHMB5bRT");
        // 通用文字识别, 图片参数为远程url图片
        JSONObject jsonObject = client.basicGeneral(encoderUrl, new HashMap<String, String>());
        JSONArray jsonArray = jsonObject.getJSONArray("words_result");
        List<Object> list = jsonArray.toList();
        return list;
    }
}
