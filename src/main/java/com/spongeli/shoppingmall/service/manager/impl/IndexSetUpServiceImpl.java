package com.spongeli.shoppingmall.service.manager.impl;

import com.alibaba.fastjson.JSONObject;
import com.spongeli.shoppingmall.common.exception.SystemException;
import com.spongeli.shoppingmall.common.system.BaseService;
import com.spongeli.shoppingmall.common.system.SystemConstant;
import com.spongeli.shoppingmall.entity.request.index.IndexSetUpInparam;
import com.spongeli.shoppingmall.entity.request.index.UpdateIndexSetUpInparam;
import com.spongeli.shoppingmall.pojo.dao.MallIndexSetUpMapper;
import com.spongeli.shoppingmall.pojo.model.MallIndexSetUp;
import com.spongeli.shoppingmall.pojo.model.MallIndexSetUpExample;
import com.spongeli.shoppingmall.service.manager.IndexSetUpService;
import com.spongeli.shoppingmall.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author spongeli
 * @Date 2020/1/12 9:13
 **/

@Service
public class IndexSetUpServiceImpl extends BaseService implements IndexSetUpService {
    @Autowired
    private MallIndexSetUpMapper mapper;

    /**
     * 查询所有/部分首页配置
     *
     * @param scope
     * @return
     */
    @Override
    public JSONObject gainIndexSetUpList(String scope) {
        MallIndexSetUpExample example = new MallIndexSetUpExample();
        if (!StringUtils.isEquals(scope, SystemConstant.QUERY_ALL)) {
            // 可用状态
            example.createCriteria().andStatusEqualTo(SystemConstant.YES);
        }
        List<MallIndexSetUp> setUps = mapper.selectByExample(example);
        if (CollectionUtils.isEmpty(setUps)) return null;

        List<MallIndexSetUp> banner = new ArrayList<>();
        List<MallIndexSetUp> recommend = new ArrayList<>();
        setUps.stream().forEach(item -> {
            if (Objects.equals(item.getType(), (byte) 0)) {
                banner.add(item);
            } else {
                recommend.add(item);
            }
        });

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("banner", banner);
        jsonObject.put("recommend", recommend);
        return jsonObject;
    }

    /**
     * 添加首页配置项
     *
     * @param inparam
     */
    @Override
    public void addIndexSetUp(IndexSetUpInparam inparam) {
        if (Objects.equals(inparam.getType(), (byte) 0)) {
            if (StringUtils.isEmpty(inparam.getBackGroundColor())) throw new SystemException("配置类型为轮播图，则背景颜色不能为空");
        }

        MallIndexSetUp setUp = new MallIndexSetUp();
        BeanUtils.copyProperties(inparam, setUp);
        setUp.setClickStatus(SystemConstant.YES); // 是否可点击
        setUp.setStatus(SystemConstant.YES); // 是否显示
        setUp.setCreateTime(new Date());
        mapper.insert(setUp);
    }

    /**
     * 更新状态
     * @param id
     * @param inparam
     */
    @Override
    public void updateIndexSetUp(Integer id, UpdateIndexSetUpInparam inparam) {
        isExist(id);

        MallIndexSetUp setUp = new MallIndexSetUp();
        BeanUtils.copyProperties(inparam, setUp);
        setUp.setId(id);
        mapper.updateByPrimaryKeySelective(setUp);
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id) {
        isExist(id);
        mapper.deleteByPrimaryKey(id);
    }

    private MallIndexSetUp isExist(Integer id){
        MallIndexSetUp setUp = mapper.selectByPrimaryKey(id);
        if(Objects.isNull(setUp)) throw new SystemException("配置信息【id】不存在");
        return setUp;
    }
}
