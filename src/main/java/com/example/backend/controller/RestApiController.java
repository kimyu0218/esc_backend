package com.example.backend.controller;

import com.example.backend.etc.Form;
import com.example.backend.service.implement.DirectionSearchServiceImpl;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class RestApiController {

    @Autowired
    DirectionSearchServiceImpl directionSearchService;

    @GetMapping
    public String welcome(){
        return "The Server is running...";
    }
    /*
    // 1. 폼 형태
    @PostMapping
    public double[][] drive(@ModelAttribute Form form) throws IOException, ParseException {
        return directionSearchService.findRoute(form.getAuth(), form.getStart_lng(), form.getStart_lat(), form.getEnd_lng(), form.getStart_lat());
    }
    */

    // 2. 파라미터 형태
    @PostMapping("/api/drive")
    public double[][] drive(@RequestParam ("auth") int auth,
                            @RequestParam("start_lat") double start_lat, @RequestParam("start_lng") double start_lng,
                            @RequestParam("end_lat") double end_lat, @RequestParam("end_lng") double end_lng) throws IOException, ParseException {
        System.out.println("백엔드 연결");
        return directionSearchService.findRoute(auth, start_lng, start_lat, end_lng, end_lat);
    }

    /*
    // 2-1. 파라미터 형태
    @PostMapping("/api/drive")
    public double[][] drive(@RequestParam Map map) throws IOException, ParseException {
        System.out.println("백엔드 연결");
        System.out.println("map: " + map);
        return null;//directionSearchService.findRoute(auth, start_lng, start_lat, end_lng, end_lat);
    }
    */
}
