package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Entity concrete logic:-
@Service
public class TopicService {

	public List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic(1, "raghu", "tfgyhj"),
			new Topic(1, "raghu", "tfgyhj"), new Topic(1, "raghu", "tfgyhj")

	));

	public List<Topic> getAllTopics() {
		return topics;
	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getClass().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			if (t.getClass().equals(id)) {
				topics.set(i, topic);
				return;
			} // if
		} // for
	}// updateTopic()

	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getClass().equals(id));
	}

}// class
