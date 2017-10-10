package ru.springboot.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.springboot.test.Model.Disk;
import ru.springboot.test.Service.DiskServiceImpl;

import java.util.List;

@Controller
public class DiskController {

    public static final String REQUEST_METHOD_VIEW_NAME = "request_method";

    @Autowired
    public DiskServiceImpl diskService;

//    @GetMapping("disk")
//    public ResponseEntity<List<Disk>> getAllDisk() {
//        List<Disk> list = diskService.getAllDisk();
//        return new ResponseEntity<List<Disk>>(list, HttpStatus.OK);
//    }

//    @RequestMapping(value="/", method = RequestMethod.GET)
//    @GetMapping(value="/index")
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView allDisk(Model model){
//        model.addAttribute("method", "get");
//        return REQUEST_METHOD_VIEW_NAME;
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        List<Disk> result = diskService.getAllDisk();
        mav.addObject("disk", result);
        return mav;
//        return "index";
//        return new ModelAndView("index");
//        return diskService.getAllDisk().toString();
//        Disk user = new Disk(); //можем здесь, например, достать из базы пользователя с ником name
//        user.setFirstName("FirstName");
//        user.setLastName("LastName");
//
//        return user;
    }
}
