package com.nandini.smsrestservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping(value = "simplerest")
public class SimpleRestController {
@ResponseBody
@RequestMapping(value="/getname", method=RequestMethod.GET)
public String getName(@RequestParam("id") String id, @RequestParam("dptId")Integer dptId){
	return "Nandini"+id+" department no. "+dptId;
}
}
