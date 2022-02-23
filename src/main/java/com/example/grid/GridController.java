package com.example.grid;



import com.example.game.designPattern.factory.GridFactory;
import com.example.game.designPattern.factory.IGrid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/grid")
public class GridController{


    @GetMapping
    public IGrid hello(){
        return GridFactory.createGridThree();
    }

}
