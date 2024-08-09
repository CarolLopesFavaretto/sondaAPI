package com.sondaAPI.controller;

import com.sondaAPI.service.ProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/probe")
public class ProbeController {

    @Autowired
    private ProbeService probeService;

}
