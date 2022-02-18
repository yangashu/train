package com.trkj.train.service.impl;

import com.trkj.train.entity.PersonalNotepad;
import com.trkj.train.mapper.PersonalNotepadMapper;
import com.trkj.train.service.IPersonalNotepadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 沈杨卓
 * @since 2022-01-17
 */
@Service
public class PersonalNotepadServiceImpl extends ServiceImpl<PersonalNotepadMapper, PersonalNotepad> implements IPersonalNotepadService {

    @Autowired
    private PersonalNotepadMapper notepadMapper;


    @Override
    public int tj(PersonalNotepad notepad) {
        System.out.println("aaa"+notepad);
        int insert = notepadMapper.insert(notepad);
        return insert;
    }

    @Override
    public List<PersonalNotepad> selectDate() {
        return notepadMapper.selectList(null);
    }

    @Override
    public int up(PersonalNotepad notepad) {
        int i = notepadMapper.updateById(notepad);
        return i;
    }
}
