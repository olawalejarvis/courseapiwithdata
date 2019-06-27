package io.javabrains.springbootstarter.course;

import java.util.List;
import java.util.Optional;

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
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllTopic(@PathVariable("id") String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Optional<Course> getTopic(@PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/topics/{topicId}/courses/{courseId}")
	public void updateTopic(@RequestBody Course course, @PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(courseId, course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/topics/{topicId}/courses/{courseId}")
	public void deleteTopic(@PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
		courseService.deleteCourse(courseId);
	}
	
	
}
