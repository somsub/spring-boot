package io.javabrains.springbootstarter.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("java", "Core Java", "Core Java Course"),
			new Topic("spring", "Core Spring", "Core Spring Course"),
			new Topic("javascript", "JavaScipt and JQuery", "JavaScript Course"),
			new Topic("scala", "Scala Fundamentals", "Scala Fundamentals Course")));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void insertTopic(Topic topic) {
		topics.add(topic);
	}

	public void deleteTopic(String id) {
		Topic topic = topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		if (topic != null) {
			topics.remove(topic);
		}
	}

	
	public void updateTopic(Topic topic) {
		Topic topicInList = topics.stream().filter(t -> t.getId().equals(topic.getId())).findFirst().get();
		if (topicInList != null) {
			topics.remove(topicInList);
			topics.add(topic);
		}
		
	}

}
