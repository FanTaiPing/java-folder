package me.zhengjie.modules.train.service.Impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.zhengjie.modules.train.mapper.InterviewMapper;
import me.zhengjie.modules.train.entity.Interview;
import me.zhengjie.modules.train.service.IInterviewService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置信息表 服务类
 * </p>
 *
 *
 * @since 2019-05-21
 */
@Service
public class InterviewServiceImpl extends ServiceImpl<InterviewMapper, Interview>   implements IInterviewService {

}

