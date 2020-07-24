package com.kantar.airways.common.mapper;

import com.kantar.airways.domain.entity.CourseEntity;
import com.kantar.airways.service.course.model.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO courseToCourseDto(CourseEntity course);

    CourseEntity courseDtoToCourse(CourseDTO course);
}
