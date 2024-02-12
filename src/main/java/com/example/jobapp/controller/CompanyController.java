package com.example.jobapp.controller;

import com.example.jobapp.Service.CompanyService;
import com.example.jobapp.entity.Company;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;

    @GetMapping
    ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if(company !=null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> updateCopmany(@PathVariable Long id, @RequestBody Company company){
        companyService.updateCompany(id, company);
        return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);

        if(isDeleted){
            return new ResponseEntity<>("Company deleted successfully", HttpStatus.OK);
        }else{
            return  new ResponseEntity<>("Company not found",HttpStatus.NOT_FOUND);
        }
    }


}
