package com.softuni.shampooCompany.services;

import com.softuni.shampooCompany.repositories.LabelRepository;
import com.softuni.shampooCompany.services.interfaces.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    @Autowired
    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }


}
