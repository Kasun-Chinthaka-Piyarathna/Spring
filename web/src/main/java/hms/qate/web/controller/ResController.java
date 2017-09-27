package hms.qate.web.controller;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class ResController {


    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public
    @ResponseBody
    JSONObject getShopInJSON(@PathVariable String name) {


        JSONObject aaa = new JSONObject();
        aaa.put("aaa", "kasun");
        aaa.put("bbb", "Chinthaka");

//        Shop shop = new Shop();
//        shop.setName(name);
//        shop.setStaffName(new String[]{"mkyong1", "mkyong2"});
//
//        return shop;

        return aaa;


    }
}
