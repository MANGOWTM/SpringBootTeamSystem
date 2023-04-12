package com.wtmc.springbootteamsystem.service.imp;

import com.wtmc.springbootteamsystem.entity.Answer;
import com.wtmc.springbootteamsystem.entity.OjSubmit;
import com.wtmc.springbootteamsystem.service.OjSubmitService;
import com.wtmc.springbootteamsystem.util.Result;
import com.wtmc.springbootteamsystem.util.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OjSubmitServiceImpl implements OjSubmitService {
    @Override
    public Result submitTest(OjSubmit ojSubmit) {
        Task task = new Task();
        Answer answer = task.compileAndRun(ojSubmit);
        return Result.ok("提交测试结果",answer);
    }
}
