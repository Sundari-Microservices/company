package com.alphabet.linkedin.companyms.company;


import com.alphabet.linkedin.companyms.company.clients.ReviewClient;
import com.alphabet.linkedin.companyms.company.dto.ReviewMessage;
import com.alphabet.linkedin.companyms.company.impl.CompanyServiceImpl;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ComapnyService implements CompanyServiceImpl {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ReviewClient reviewClient;
    /**
     * @return
     */
    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Company getCompanyById(long id) {
        return companyRepository.findById(id).orElse(null);
    }

    /**
     * @param company
     * @return
     */
    @Override
    public boolean createCompany(Company company) {
        companyRepository.save(company);
        return true;
    }

    /**
     * @param id
     * @param updatedcompany
     * @return
     */
    @Override
    public boolean updateCompany(long id, Company updatedcompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if( company != null){
           company.setCompanyName(updatedcompany.getCompanyName());
           company.setCompanyDescription(updatedcompany.getCompanyDescription());
           company.setCompanyLocation(updatedcompany.getCompanyLocation());
           company.setRating(updatedcompany.getRating());
           companyRepository.save(company);
           return true;
        } else {
            return false;
        }
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        Company company = companyRepository.findById(reviewMessage.getCompanyId())
                .orElseThrow(()-> new NotFoundException("Company Not Found:"+reviewMessage.getCompanyId()));
        double averageRating = reviewClient.getAverageRatingForCompany(reviewMessage.getCompanyId());
        company.setRating(averageRating);
        companyRepository.save(company);
//        System.out.println(reviewMessage.toString());
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean deleteCompanyById(long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }
}
