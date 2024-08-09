package com.sondaAPI.service;

import com.sondaAPI.repository.ProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProbeService {

    @Autowired
    private ProbeRepository probeRepository;
}
