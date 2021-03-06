package com.termii.visitorslogapplication.controller;

import com.termii.visitorslogapplication.data.model.Staff;
import com.termii.visitorslogapplication.dto.request.LoginDto;
import com.termii.visitorslogapplication.dto.request.NewVisitRequest;
import com.termii.visitorslogapplication.dto.request.StaffDto;
import com.termii.visitorslogapplication.service.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/")
public class StaffController {
    private StaffService staffService;


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){

        return  new ResponseEntity<>("successfull", HttpStatus.OK);
    }

    @PostMapping("/visit")
    public ResponseEntity<?> logNewVisit(@RequestBody NewVisitRequest newVisitRequest){

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/staff")
    public ResponseEntity<?> addNewStaff(@RequestBody StaffDto staffDto){
        Staff staff = staffService.addNewStaff(staffDto);
        return new ResponseEntity<>(staff, HttpStatus.CREATED) ;
    }

    @GetMapping("/staff")
    public ResponseEntity<?> getAllStaff(){
       List<Staff> staffList = staffService.getAllStaff();
       return new ResponseEntity<>(staffList, HttpStatus.OK);

    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<?> getSpecificStaff(@PathVariable Long id){
        Optional<Staff> staff = staffService.findStaff(id);
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);
    }

}
