package org.itstep.os;

import org.itstep.firm.Firm;
import org.itstep.firm.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class OsRestController {
    @Autowired
    private OsService OsService;

    @GetMapping(value = "/oss")
    public List<Os> firms() {
        return OsService.findAll();
    }

}

