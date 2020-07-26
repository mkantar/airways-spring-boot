package com.kantar.airways.common.mapper;

import org.mapstruct.Mapper;

import com.kantar.airways.domain.entity.CourseEntity;
import com.kantar.airways.service.course.model.dto.CourseDTO;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDTO courseToCourseDto(CourseEntity course);

    CourseEntity courseDtoToCourse(CourseDTO course);
}
