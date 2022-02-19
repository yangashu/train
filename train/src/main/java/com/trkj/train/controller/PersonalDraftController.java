package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.DraftView;
import com.trkj.train.entity.PersonalDraft;
import com.trkj.train.service.impl.PersonalDraftServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@RestController
@RequestMapping("/personal-draft")
public class PersonalDraftController {
    @Autowired
    private PersonalDraftServiceImpl draftService;
    @PostMapping("/addcg")
    public int addcg(@RequestBody PersonalDraft draft){
        int a = draftService.add(draft);
        return a;
    }

    @GetMapping("/pageselect")
    public IPage<DraftView> Neiron(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("id") int id){
        IPage<DraftView> iPage= draftService.pageselect(page, size,id);
        return iPage;
    }

    @PostMapping("/xg")
    public int xg(@RequestBody PersonalDraft draft){
        int a = draftService.upzt(draft);
        return a;
    }
}
