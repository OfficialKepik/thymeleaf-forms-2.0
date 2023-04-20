package org.itstep.firm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* ЧТО ЭТО ТАКОЕ*/
@RestController
@RequestMapping("/api")
public class FirmRestController {
    @Autowired
    private FirmService firmService;

    @GetMapping(value = "/firms")
    public List<Firm> firms() {
        return firmService.findAll();
    }

}