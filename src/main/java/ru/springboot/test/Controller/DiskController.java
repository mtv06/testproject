package ru.springboot.test.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.springboot.test.Model.Disk;
import ru.springboot.test.Service.DiskServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class DiskController {

    @Autowired
    public DiskServiceImpl diskService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allDisk(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        List<Disk> result = diskService.getAllDisk();
        mav.addObject("disk", result);
        return mav;
    }

    @RequestMapping(value = "/free-disk", method = RequestMethod.GET)
    public ModelAndView freeDisk(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("free-disk");
        List<Disk> result = diskService.getFreeDisk();
        Iterator itr = result.iterator();
        List<Disk> disk = new ArrayList<>();
        while(itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            String name = String.valueOf(obj[0]);
            String description = String.valueOf(obj[1]);
            Disk disks = new Disk();
            disks.setName(name);
            disks.setDescription(description);
            disk.add(disks);
        }
        mav.addObject("disk", disk);
        return mav;
    }

    @RequestMapping(value = "/disk-taken-by-user", method = RequestMethod.GET)
    public ModelAndView takenByUserDisk(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("disk-taken-by-user");
        List<Disk> result = diskService.getDiskTakenByUser();
        mav.addObject("disk", result);
        return mav;
    }

    @RequestMapping(value = "/disk-taken-from-user", method = RequestMethod.GET)
    public ModelAndView takenFromUserDisk(Model model){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("disk-taken-from-user");
        List<Disk> result = diskService.getDiskTakenFromUser();
        mav.addObject("disk", result);
        return mav;
    }
    @RequestMapping(value = "/add-disk", method = RequestMethod.POST)
    public ModelAndView addDisk(@ModelAttribute Disk disk, Model model){
        model.addAttribute("disk", disk);
        diskService.addDisk(disk);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/index");
        return mav;
    }

    @RequestMapping(value="/add-disk", method=RequestMethod.GET)
    public String diskForm(Model model) {
        model.addAttribute("disk", new Disk());
        return "add-disk";
    }
}
