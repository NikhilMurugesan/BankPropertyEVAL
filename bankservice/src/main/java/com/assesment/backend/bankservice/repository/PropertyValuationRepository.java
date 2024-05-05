package com.assesment.backend.bankservice.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.assesment.backend.bankservice.model.FacilityDetail;
import com.assesment.backend.bankservice.model.PropertyValuation;

import java.util.List;

@Repository
public interface PropertyValuationRepository extends JpaRepository<PropertyValuation, Long> {

    @Async
   //@Query(value = "SELECT pv.fos_reference, mb.customer_name, fd.amount m, pv.*  FROM Property_Valuation pv  JOIN Facility_Detail fd  LEFT JOIN Main_Borrower mb        ON pv.fos_reference = '' LEFT JOIN Joint_Borrower jb      ON pv.fos_reference = fosReference",nativeQuery = true)
   
   @Query(value = "SELECT fd.* FROM `Facility_Detail` fd JOIN `Property_Valuation` pv ON fd.Facility_ID = pv.Facility_ID WHERE pv.FOS_Reference = :fosReference",nativeQuery = true) 
   public List<Object[]> findPropertyDetailsByFOSReference(@Param("fosReference") String fosReference);

  /* * @Query("SELECT pv.fosReference, fd.address, mb.customerName, jb.customerName, c.date " +
    "FROM PropertyValuation pv " +
    "JOIN pv.facility fd " +
    "LEFT JOIN fd.mainBorrowers mb " +
    "LEFT JOIN mb.jointBorrowers jb " +
    "LEFT JOIN fd.comments c ")
    List<Object[]> findPropertyDetails(String fosReference);*/


    //public List<Object[]> findPropertyDetailsByFOSReference(@Param("fosReference") String fosReference);

}
