package com.wtmc.springbootteamsystem.mapper;

import com.wtmc.springbootteamsystem.entity.Eo.OjProblemEo;
import com.wtmc.springbootteamsystem.entity.Vo.OjProblem;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OjProblemMapper {
    public void addProblem(OjProblem ojProblem);
    public void deleteProblem(int id);
    public List<OjProblem> searchProblem(OjProblemEo ojProblemEo);
}
