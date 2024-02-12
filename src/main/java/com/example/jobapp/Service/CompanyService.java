package com.example.jobapp.Service;

import com.example.jobapp.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    void createCompany(Company company);
    boolean updateCompany(Long id, Company company);
    boolean deleteCompanyById(Long id);

}
