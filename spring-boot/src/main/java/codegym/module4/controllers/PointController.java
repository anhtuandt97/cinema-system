package codegym.module4.controllers;


import codegym.module4.entities.Point;
import codegym.module4.entities.Customer;
import codegym.module4.services.PointService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(PointController.BASE_URL)
public class PointController {

    public static final String BASE_URL = "/api/v1/point";
    private final PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    @GetMapping
    public List<Point> getAllPoint() {
        return pointService.findAllPoint();
    }


    @GetMapping("/{id}")
    public List<Point> getPointDetails(@PathVariable Customer id) {



        return pointService.findPointByDate(id);
    }


    @GetMapping("{id}/{from}/{to}/{status}")
    public List<Point> getPointDetailsDate(@PathVariable Customer id, @PathVariable("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from, @PathVariable("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to
            , @PathVariable String status) {

        return pointService.findPointByDate2(from, to, id ,status);
    }
}