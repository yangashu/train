package com.trkj.train.controller;


import com.trkj.train.entity.PersonalNotepad;
import com.trkj.train.service.impl.PersonalNotepadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/personal-notepad")
public class PersonalNotepadController {

    @Autowired
    private PersonalNotepadServiceImpl notepadService;

    @PostMapping("/tianjia")
    public int tj(@RequestBody PersonalNotepad notepad){
        int tj = notepadService.tj(notepad);
        return tj;
    }
    @GetMapping("/selectall")
    public List<PersonalNotepad> selectall(){
        return notepadService.selectDate();
    }
    @PostMapping("/xg")
    public int xg(@RequestBody PersonalNotepad id){
        int xg = notepadService.up(id);
        return xg;
    }
}
