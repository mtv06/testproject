package ru.springboot.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.springboot.test.Service.DiskServiceImpl;

@Controller
@RequestMapping
public class DiskController {

    @Autowired
    public DiskServiceImpl diskService;

//    @GetMapping("disk")
//    public ResponseEntity<List<Disk>> getAllDisk() {
//        List<Disk> list = diskService.getAllDisk();
//        return new ResponseEntity<List<Disk>>(list, HttpStatus.OK);
//    }

    @GetMapping("/")
    public String allDisk(){
        return diskService.getAllDisk().toString();
    }
}
