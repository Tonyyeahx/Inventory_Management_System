package com.uw.cs506.team03.smartstock.controller;

import com.uw.cs506.team03.smartstock.entity.NewTable;
import com.uw.cs506.team03.smartstock.service.NewTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/*
 * Best practice for naming endpoint is not show CRUD in api.
 * using GET, POST, PUT, DELETE to methods to assign actions.
 */

@RestController
@RequestMapping("/test")
public class DemoRestController {
    private NewTableService newTableService;
    @Autowired
    public DemoRestController(NewTableService theNewTableService) {
        this.newTableService = theNewTableService;
    }

    @GetMapping("/adduser")
    public String addUser () {
        NewTable newTable = new NewTable("james", 23);
        newTableService.addUser(newTable);
        return "yeah, james added in database";
    }

    @GetMapping("/addstock/{tupleID}")
    public  String addStock(@PathVariable int tupleID) {
        newTableService.addStock(tupleID);
        return  String.format("id %d's stock + 1", tupleID);
    }

    @GetMapping("/substock/{tupleID}")
    public  String subStock(@PathVariable int tupleID) {
        newTableService.subStock(tupleID);
        return  String.format("id %d's stock - 1", tupleID);
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
