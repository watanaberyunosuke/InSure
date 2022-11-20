package com.harrybwatson.insure.phr.controller;

import com.harrybwatson.insure.phr.model.PHR;
import com.harrybwatson.insure.phr.repository.PhrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/phr")
public class PhrController {

    @Autowired
    public PhrRepository phrRepository;

    // PHR Homepage
    @GetMapping(value = {""})
    public ModelAndView getAllPhrsPage() {
        ModelAndView allPhrsMav = new ModelAndView("phrHomepage");
        allPhrsMav.addObject("phrs", phrRepository.findAll());
        return allPhrsMav;
    }

    // New PHR
    @GetMapping(value = "/new")
    public String getNewPolicyForm(Model model) {
        List<PHR> policyTypes = phrRepository.findAll();
        model.addAttribute("policyTypesList", policyTypes);
        model.addAttribute("newPHRItem", new PHR());
        return "newPhr";
    }

    @PostMapping(value = "/addnew")
    public String newPolicySubmission(@Valid PHR phr, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newPhr";
        }
        phrRepository.save(phr);
        return "actionSuccessful";
    }

    @PostMapping(value = "/delete")
    public String delete(@ModelAttribute(value="deletePhrId") Long id){
        phrRepository.deleteById(id);
        return "actionSuccessful";
    }

}
