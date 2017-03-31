package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourses(@PathVariable String topicId){
		return courseService.getAllCoursesForTopic(topicId);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id){
		return courseService.getCourse(id);
	}
	
	@RequestMapping(path="/topics/{topicId}/courses", method=RequestMethod.POST)
	public void insertCourse(@PathVariable String topicId, @RequestBody Course course){
		course.setTopic(new Topic(topicId, "",""));
		courseService.insertCourse(course); 
	}
	@RequestMapping(path="/topics/{topicId}/courses/{id}", method=RequestMethod.PUT)
	public void updateCourse(@PathVariable String topicId, @RequestBody Course course){
		course.setTopic(new Topic(topicId, "",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(path="/topics/{topicId}/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id){
		courseService.deleteCourse(id);
	}

}
