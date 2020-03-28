package com.lcwork.multimall.db.service;

import com.github.pagehelper.PageHelper;
import com.lcwork.multimall.db.dao.generate.MultimallAdminMapper;
import com.lcwork.multimall.db.domain.generate.MultimallAdmin;
import com.lcwork.multimall.db.domain.generate.MultimallAdminExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MultimallAdminService {
    private final MultimallAdmin.Column[] result = new MultimallAdmin.Column[]{MultimallAdmin.Column.id, MultimallAdmin.Column.username, MultimallAdmin.Column.avatar, MultimallAdmin.Column.roleIds};
    @Resource
    private MultimallAdminMapper adminMapper;

    public List<MultimallAdmin> findAdmin(String username) {
        MultimallAdminExample example = new MultimallAdminExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }

    public MultimallAdmin findAdmin(Integer id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public List<MultimallAdmin> querySelective(String username, Integer page, Integer limit, String sort, String order) {
        MultimallAdminExample example = new MultimallAdminExample();
        MultimallAdminExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, limit);
        return adminMapper.selectByExampleSelective(example, result);
    }

    public int updateById(MultimallAdmin admin) {
        admin.setUpdateTime(LocalDateTime.now());
        return adminMapper.updateByPrimaryKeySelective(admin);
    }

    public void deleteById(Integer id) {
        adminMapper.logicalDeleteByPrimaryKey(id);
    }

    public void add(MultimallAdmin admin) {
        admin.setAddTime(LocalDateTime.now());
        admin.setUpdateTime(LocalDateTime.now());
        adminMapper.insertSelective(admin);
    }

    public MultimallAdmin findById(Integer id) {
        return adminMapper.selectByPrimaryKeySelective(id, result);
    }

    public List<MultimallAdmin> all() {
        MultimallAdminExample example = new MultimallAdminExample();
        example.or().andDeletedEqualTo(false);
        return adminMapper.selectByExample(example);
    }
}
