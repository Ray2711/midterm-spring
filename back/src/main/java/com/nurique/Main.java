package com.nurique;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main{
    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public static void main(String[] args){
       // System.out.println("nurique");
        SpringApplication.run(Main.class, args);
    }
    @CrossOrigin(origins = "*")
    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll(); 
    }

    record NewCustomerRequest(
        String name,
        String email,
        Integer age
    ){}

    @CrossOrigin(origins = "*")
    @PostMapping(consumes = {"application/json"})
    public void addCustomer(@RequestBody NewCustomerRequest req){
        Customer customer = new Customer();
        customer.setName(req.name());
        customer.setAge(req.age());
        customer.setEmail(req.email());
        customerRepository.save(customer);
    }
    @CrossOrigin(origins = "*")
    @PutMapping("{customerId}")
    public void UpdateCustomer(@RequestBody NewCustomerRequest req,@PathVariable("customerId") Integer id){
        Customer customer = customerRepository.getReferenceById(id);
        customer.setName(req.name());
        customer.setAge(req.age());
        customer.setEmail(req.email());
        customerRepository.save(customer);  
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id){
        customerRepository.deleteById(id);
    }

}