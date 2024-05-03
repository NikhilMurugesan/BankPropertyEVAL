package com.assesment.backend.bankservice.service;

import com.assesment.backend.bankservice.model.FacilityDetail;
import com.assesment.backend.bankservice.repository.FacilityDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FacilityDetailService {

    private final FacilityDetailRepository facilityDetailRepository;

    @Autowired
    public FacilityDetailService(FacilityDetailRepository facilityDetailRepository) {
        this.facilityDetailRepository = facilityDetailRepository;
    }

    public List<FacilityDetail> getAllFacilities() {
        return facilityDetailRepository.findAll();
    }

    public FacilityDetail getFacilityById(Long id) {
        return facilityDetailRepository.findById(id).orElse(null);
    }

    public FacilityDetail addFacility(FacilityDetail facilityDetail) {
        return facilityDetailRepository.save(facilityDetail);
    }

    public FacilityDetail updateFacility(Long id, FacilityDetail updatedFacilityDetail) {
        FacilityDetail existingFacilityDetail = facilityDetailRepository.findById(id).orElse(null);
        if (existingFacilityDetail != null) {
            // Update existing facility with the new details
            existingFacilityDetail.setType(updatedFacilityDetail.getType());
            existingFacilityDetail.setCategory(updatedFacilityDetail.getCategory());
            existingFacilityDetail.setPurpose(updatedFacilityDetail.getPurpose());
            existingFacilityDetail.setTermMonths(updatedFacilityDetail.getTermMonths());
            existingFacilityDetail.setCurrency(updatedFacilityDetail.getCurrency());
            existingFacilityDetail.setAmount(updatedFacilityDetail.getAmount());
            return facilityDetailRepository.save(existingFacilityDetail);
        } else {
            return null;
        }
    }

    public void deleteFacility(Long id) {
        facilityDetailRepository.deleteById(id);
    }
}
