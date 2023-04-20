package org.itstep.os;

import org.itstep.firm.Firm;
import org.itstep.firm.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
public class OsController {
    @Autowired
    OsService osService;


    @GetMapping(value = "/oss")
    public String smarts(Model model) {
        model.addAttribute("oss", osService.findAll());
        return "oss";
    }


    @GetMapping(value = "/os_add")
    public String smartAdd(Model model) {
        model.addAttribute("os", new Os());
        return "os_add";
    }

    @PostMapping(value = "/os_add")
    public String smartSave(Os os, Model model, HttpServletResponse response) {
        Os newOs = osService.save(os);
        long id = newOs.getId();
        response.addHeader("id", String.valueOf(id));
        model.addAttribute("oss", osService.findAll());
        return "redirect:/oss";
    }

    //DeleteMapping
    @PostMapping(value = "/os_delete")
    public String smartDelete(@RequestParam(name = "id") Long id) {
        osService.deleteById(id);
        return "redirect:/oss";
    }

    @GetMapping(value = "/os_update")
    public String smartGetUpdate(Model model, @RequestParam(name = "id") Long id) {
        Os oldOs = osService.findById(id);
        model.addAttribute("os", oldOs);
        return "os_update";
    }

    //PutMapping
    @PostMapping(value = "/os_update")
    public String smartUpdate(Os os, Model model) {
        Os oldOs = osService.findById(os.getId());
        oldOs.setName(os.getName());
        oldOs.setDeveloper(os.getDeveloper());
        osService.save(oldOs);
        model.addAttribute("oss", osService.findAll());
        return "redirect:/oss";
    }
}

