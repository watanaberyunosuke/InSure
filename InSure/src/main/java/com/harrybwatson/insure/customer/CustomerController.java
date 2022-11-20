package com.harrybwatson.insure.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Customer Homepage
    @GetMapping(value = {""})
    public ModelAndView getAllCustomersPage() {
        ModelAndView allCustomersMav = new ModelAndView("customerHomepage");
        allCustomersMav.addObject("customers", customerRepository.findAll());
        return allCustomersMav;
    }

    // New Customer
    @GetMapping(value = "/new")
    public String getNewCustomerForm(Model model) {
        model.addAttribute("newCustomerItem", new Customer());
        return "newCustomer";
    }

    @PostMapping(value = "/addnew")
    public String newCustomerSubmission(@Valid Customer customer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newCustomer";
        }
        customerRepository.save(customer);
        return "actionSuccessful";
    }


}
