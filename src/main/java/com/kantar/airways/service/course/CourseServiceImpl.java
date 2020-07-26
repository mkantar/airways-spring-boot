package com.kantar.airways.service.course;

import com.kantar.airways.common.exception.BusinessException;
import com.kantar.airways.common.exception.NotFoundException;
import com.kantar.airways.common.mapper.AirportMapper;
import com.kantar.airways.common.mapper.CourseMapper;
import com.kantar.airways.domain.entity.CourseEntity;
import com.kantar.airways.domain.repository.CourseRepository;
import com.kantar.airways.service.airport.AirportService;
import com.kantar.airways.service.airport.model.request.RequestGetAirport;
import com.kantar.airways.service.airport.model.response.ResponseGetAirport;
import com.kantar.airways.service.course.model.dto.CourseDTO;
import com.kantar.airways.service.course.model.request.RequestCreateCourse;
import com.kantar.airways.service.course.model.request.RequestGetAllCourses;
import com.kantar.airways.service.course.model.request.RequestGetCourse;
import com.kantar.airways.service.course.model.response.ResponseCreateCourse;
import com.kantar.airways.service.course.model.response.ResponseGetAllCourses;
import com.kantar.airways.service.course.model.response.ResponseGetCourse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CourseServiceImpl implements CourseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CourseServiceImpl.class);

	@Autowired
	CourseMapper courseMapper;

	@Autowired
	AirportMapper airportMapper;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	AirportService airportService;

	@Override
	public ResponseGetAllCourses getAllCourses(RequestGetAllCourses request) {
        ResponseGetAllCourses response = new ResponseGetAllCourses();

        List<CourseEntity> courseList = courseRepository.findAll();

        List<CourseDTO> courseDtoList = courseList.stream().map(entity -> courseMapper.courseToCourseDto(entity)).collect(Collectors.toList());

        response.setCourses(courseDtoList);

        return response;
    }

	@Override
	public ResponseGetCourse getCourse(RequestGetCourse request) {
        ResponseGetCourse response = new ResponseGetCourse();

        Optional<CourseEntity> course = courseRepository.findById(request.getId());

        CourseEntity entity = course.orElseThrow(() -> new NotFoundException("Not found"));

        response.setCourse(courseMapper.courseToCourseDto(entity));

        return response;
    }

    @Override
    public ResponseCreateCourse createCourse(RequestCreateCourse request) throws BusinessException {
        ResponseCreateCourse response = new ResponseCreateCourse();

        try {
            ResponseGetAirport responseOriginAirport = airportService
                    .getAirport(new RequestGetAirport(request.getOriginAirportName()));
            ResponseGetAirport responseDestinationAirport = airportService
                    .getAirport(new RequestGetAirport(request.getDestinationAirportName()));

            Optional<CourseEntity> course = courseRepository.findByOriginIdAndDestinationId(
                    responseOriginAirport.getAirport().getId(), responseDestinationAirport.getAirport().getId());

            if (course.isPresent()) {
                LOGGER.warn("The course is already set");

                throw new BusinessException(3001L, "Course is already set");
            }

            CourseEntity entity = new CourseEntity();
            entity.setOriginAirport(airportMapper.airportDtoToAirport(responseOriginAirport.getAirport()));
            entity.setDestinationAirport(airportMapper.airportDtoToAirport(responseDestinationAirport.getAirport()));

            CourseEntity courseSaved = courseRepository.save(entity);
            courseRepository.flush();

            response.setCourseId(courseSaved.getId());
        } catch (NotFoundException e) {
            LOGGER.error("Cannot find one of airport. Error: ", e);

            throw new BusinessException(3002L, "Cannot set course");
        }

		return response;
	}
}
