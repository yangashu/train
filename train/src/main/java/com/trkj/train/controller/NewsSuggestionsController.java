package com.trkj.train.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.trkj.train.config.dto.ReceivingView;
import com.trkj.train.config.dto.SuggestionsView;
import com.trkj.train.entity.NewsSuggestions;
import com.trkj.train.service.impl.NewsSuggestionsServiceImpl;
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
@RequestMapping("/news-suggestions")
public class NewsSuggestionsController {
    @Autowired
    private NewsSuggestionsServiceImpl suggestionsService;

    @GetMapping("/page")
    public IPage<SuggestionsView> Neiron(@RequestParam("page") int page, @RequestParam("size") int size){
        IPage<SuggestionsView> iPage= suggestionsService.PageSelect(page, size);
        return iPage;
    }

    @PostMapping("/addnews")
    public int addnews(@RequestBody NewsSuggestions suggestions){
        int a = suggestionsService.addnews(suggestions);
        return a;
    }

    @GetMapping("/page1")
    public IPage<SuggestionsView> page1(@RequestParam("page") int page, @RequestParam("size") int size,@RequestParam("id") int id){
        IPage<SuggestionsView> iPage= suggestionsService.Page(page, size,id);
        return iPage;
    }
}
