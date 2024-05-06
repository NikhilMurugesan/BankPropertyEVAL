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

  // @Query(value = "SELECT DISTINCT a.reference_number, a.facility_id, (SELECT f.amount FROM facility_detail f WHERE f.facility_id = a.facility_id LIMIT 1) AS amount, (SELECT f.type FROM facility_detail f WHERE f.facility_id = a.facility_id LIMIT 1) AS type_of_facility, (SELECT f.category FROM facility_detail f WHERE f.facility_id = a.facility_id LIMIT 1) AS category, (SELECT CASE WHEN EXISTS (SELECT 1 FROM main_borrower m WHERE m.facility_id = a.facility_id) THEN 1 ELSE 0 END) AS has_main_borrower, mb.customer_name FROM application a LEFT JOIN main_borrower mb ON mb.facility_id = a.facility_id LIMIT 0, 1000", nativeQuery = true)
     

  /* * @Query("SELECT pv.fosReference, fd.address, mb.customerName, jb.customerName, c.date " +
    "FROM PropertyValuation pv " +
    "JOIN pv.facility fd " +
    "LEFT JOIN fd.mainBorrowers mb " +
    "LEFT JOIN mb.jointBorrowers jb " +
    "LEFT JOIN fd.comments c ")
    List<Object[]> findPropertyDetails(String fosReference);*/


    //public List<Object[]> findPropertyDetailsByFOSReference(@Param("fosReference") String fosReference);

}
