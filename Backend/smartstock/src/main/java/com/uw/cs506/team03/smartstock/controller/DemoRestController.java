package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.NewTable;
import com.uw.cs506.team03.smartstock.service.NewTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class DemoRestController {
    private NewTableService newTableService;
    @Autowired
    public DemoRestController(NewTableService theNewTableService) {
        this.newTableService = theNewTableService;
    }

    @GetMapping("/hello")
    public String hello () {
        return "hi";
    }

    @GetMapping("/adduser")
    public String addUser () {
        NewTable newTable = new NewTable("james", 23);
        newTableService.addUser(newTable);
        return "yeah, james added in database";
    }

    @GetMapping("/addstock")
    public  String addStock() {
        newTableService.addStock(1);
        return  "id 1's stock + 1";
    }

    @GetMapping("/substock")
    public  String subStock() {
        newTableService.subStock(1);
        return  "id 1's stock - 1";
    }

    @GetMapping("sqltesting")
    public NewTable sqlTesting() {
        return newTableService.sqlTesting();
    }
    @GetMapping("gettuple/{tupleID}")
    public NewTable getTuple(@PathVariable int tupleID) {
        NewTable theTuple = newTableService.findById(tupleID);

        if(theTuple == null) {
            throw new RuntimeException("tuple not find. id is " + tupleID);
        }
        else {
            return theTuple;
        }
    }

    @PostMapping("/addtuple")
    public NewTable addTuple(@RequestBody NewTable theTuple) {
        //in cases frontend give it id (it should not because id == 0 is for insert)
        theTuple.setId(0);
        return newTableService.save(theTuple);
    }

    @PutMapping("/updatetuple")
    public NewTable updateTuple(@RequestBody NewTable theTuple) {
        NewTable updatedTuple = newTableService.save(theTuple);
        return updatedTuple;
    }

    @DeleteMapping("/deletetuple/{tupleID}")
    public String deleteTuple(@PathVariable int tupleID) {
        NewTable theTuple = newTableService.findById(tupleID);
        if(theTuple == null) {
            throw new RuntimeException(String.format("tupleID: %d not found", tupleID));
        }

        newTableService.deleteById(tupleID);
        return String.format("tupleID: %d deleted", tupleID);
    }
}
