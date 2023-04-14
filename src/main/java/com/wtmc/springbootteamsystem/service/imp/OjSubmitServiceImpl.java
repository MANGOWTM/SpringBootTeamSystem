package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Vo.Answer;
import com.wtmc.springbootteamsystem.entity.Vo.OjSubmit;
import com.wtmc.springbootteamsystem.service.OjSubmitService;
import com.wtmc.springbootteamsystem.util.Result;
import com.wtmc.springbootteamsystem.util.Task;
import org.springframework.stereotype.Service;

@Service
public class OjSubmitServiceImpl implements OjSubmitService {
    @Override
    public Result submitTest(OjSubmit ojSubmit) {
        Task task = new Task();
        Answer answer = task.compileAndRun(ojSubmit);
        return Result.ok("提交测试结果",answer);
    }
}
