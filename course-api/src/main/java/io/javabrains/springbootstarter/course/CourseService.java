package io.javabrains.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCoursesForTopic(String topicId) {
		return courseRepository.findByTopicId(topicId);
	}

	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}

	public void insertCourse(Course topic) {
		courseRepository.save(topic);
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);
	}

	
	public void updateCourse(Course course) {
		courseRepository.save(course);		
	}

}
