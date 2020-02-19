package topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

//Entity concrete logic:-
@Service
public class TopicService {

	/*
	 * 1.I created my List my hardcoded List of 'topics' using Arrays.asList.
	 * 2.And, this Arrays.asList method creates a non-mutable array.
	 * 3.In ordr to edit the List, which is passed to the new ArrayList<> constructor, 
	 * so i get the copy of that List so it is mutable so i can push things to it etc...
	 * 
	 */
	
	public List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
			new Topic(1, "raghu", "tfgyhj"),
			new Topic(1, "raghu", "tfgyhj"), 
			new Topic(1, "raghu", "tfgyhj")

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

	/*
	 *1.In this method im going to use a simple for-loop.
	 *2.To loop through the List of 'topics' and get the one which has id,
	 *  same as the input id and the update the 'topic'.
	 */
	public void updateTopic(String id, Topic topic) {
		for (int i = 0; i < topics.size(); i++) {
			Topic t = topics.get(i);
			//3.if the id matches then replace using set method, 
			//giving first parameter as index 'i' and 'topic' as element. 
			if (t.getClass().equals(id)) {
				topics.set(i, topic);
				return;
			} // if
		} // for
		//4.its gone a loop through depending on the size of the topic thrugh that many topics.size().
		//5.And, for each topic, in that List is going to compare the id using equals(id) that is String input id.
		//6.And, if it matches that location im going to  send updated content  set it to the List and just return.
		//7.So, this is kind of a service.
	}// updateTopic()

	
	/*
	 *1.im just gone a get the topics array and we use the removeIf method takes predicate lamda expression.
	 *2.And, removes all topics in the List where thepredicate stroke, in this case the predicate is basically for a Topic,
	 *(t -> t.getId().equals(id)) of the input id.
	 *3.And, you are filtering here.
	 *4.So, this is delete topic method.   
	 */
	
	public void deleteTopic(String id) {
		topics.removeIf(t -> t.getClass().equals(id));
	}

}// class
