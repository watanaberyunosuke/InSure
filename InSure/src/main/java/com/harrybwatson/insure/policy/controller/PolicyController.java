package com.harrybwatson.insure.policy.controller;

import com.harrybwatson.insure.policy.model.Policy;
import com.harrybwatson.insure.policy.model.PolicyType;
import com.harrybwatson.insure.policy.repository.PolicyRepository;
import com.harrybwatson.insure.policy.repository.PolicyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/policy")
public class PolicyController {

    @Autowired
    private PolicyTypeRepository policyTypeRepository;

    @Autowired
    private PolicyRepository policyRepository;

    // Policy Homepage
    @GetMapping(value = {""})
    public ModelAndView getAllPoliciesPage() {
        ModelAndView allPoliciesMav = new ModelAndView("policyHomepage");
        allPoliciesMav.addObject("policies", policyRepository.findAll());
        return allPoliciesMav;
    }

    // New Policy
    @GetMapping(value = "/new")
    public String getNewPolicyForm(Model model) {
        List<PolicyType> policyTypes = policyTypeRepository.findAll();
        model.addAttribute("policyTypesList", policyTypes);
        model.addAttribute("newPolicyItem", new Policy());
        return "newPolicy";
    }

    @PostMapping(value = "/addnew")
    public String newPolicySubmission(@Valid Policy policy, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newPolicy";
        }
        policyRepository.save(policy);
        return "actionSuccessful";
    }

    /**
     * MAV related to Policy Types
     */

    @GetMapping(value = {"/policyType"})
    public ModelAndView getAllPolicyTypesPage() {
        ModelAndView allPolicyTypesMav = new ModelAndView("policyTypes");
        allPolicyTypesMav.addObject("policyTypes", policyTypeRepository.findAll());
        return allPolicyTypesMav;
    }

    @GetMapping(value = "/policyType/new")
    public String newPolicyType(Model model) {
        model.addAttribute("newPolicyTypeItem", new PolicyType());
        return "newPolicyType";
    }

    @PostMapping(value = "/policyType/addnew")
    public String newPolicyTypeSubmission(@Valid PolicyType policyType, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newPolicyType";
        }
        policyTypeRepository.save(policyType);
        return "actionSuccessful";
    }
}
