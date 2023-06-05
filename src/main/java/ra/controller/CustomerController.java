package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import ra.model.Customer;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("customers")
public class CustomerController {
    @ModelAttribute("customers")
    public List<Customer> setupCustomers(){
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1,"thang", 20));
        customers.add(new Customer(2,"ba", 20));
        customers.add(new Customer(3,"huyen", 20));
        return customers;
    }
    @GetMapping("/")
    public String showIndex(@ModelAttribute("customers") List<Customer> customers, Model model) {
        model.addAttribute("customers", customers);
        return "/index";
    }
    @GetMapping("/delete/{index}")
    public String doDelete(@PathVariable int index,
                           @ModelAttribute("customers") List<Customer> customers) {
        customers.remove(index);
        return "redirect:/";
    }
}
