package ru.springboot.test.Controller;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.springboot.test.Model.Disk;
import ru.springboot.test.Service.DiskServiceImpl;

import java.util.HashMap;
import java.util.List;

@Controller
public class DiskController {

    @Autowired
    public DiskServiceImpl diskService;

//    @GetMapping("disk")
//    public ResponseEntity<List<Disk>> getAllDisk() {
//        List<Disk> list = diskService.getAllDisk();
//        return new ResponseEntity<List<Disk>>(list, HttpStatus.OK);
//    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String allDisk(){
        Disk user = new Disk(); //можем здесь, например, достать из базы пользователя с ником name
        user.setFirstName("FirstName");
        user.setLastName("LastName");

        return user;
    }
}
