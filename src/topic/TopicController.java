package topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TopicController {

	// Concrete dependency:-
	@Autowired
	private TopicService topicService;

	// 1.'GET' all resources:-
	// If you don't specify method it is by default GET request:-
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	// 2.'GET' the details of the given id reference:-
	/*
	 * 1.You pass an argument, that you really want from the request. 
	 * 2.And, you have add the annotation which tells Spring MVC, what type of the request
	 * payload you need to pick inorder to Spring MVC. 
	 * 3.Pick that thing from request object and send to me.
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}

	// 3.'POST' the refrence to the List type of 'Topic':-
	/*
	 * 1.Pick this instance: 'Topic' from the request body: 'topic'. 
	 * 2.There is an annottaion for that which is @RequestBody: so what this does us. 
	 * 3.It tells the Spring MVC, that your request payload is going to contain, a json
	 * representation of this: 'Topic' instance. 
	 * 4.And, you are asking to take that request body and convert it into a 'Topic' instance and pass it to the
	 * addTopic(), when this url is met. 
	 * 5.So you gone a get an instance of the Topic i.e is: 'topic' thats all ready for you to add to the List. 
	 * 6.create a method on TopicService, which adds the Topic instance. 
	 * 7.I can make a post request to the "/topics" and i passing the topic object 
	 * and its going to cretae a new 'Topic' for me. 
	 * 8.So this is a post request.
	 * 9.create a raw payload from the Body of postman so its a simple object payload send that in the body.
	 * 10.Before i submit this request we have to set in the Headers section: key-value,
	 * Content-Type - application/json.
	 * 11.Inorder to tell your Spring MVC, what you are sending that is json String.
	 * 12.So, it takes that and converts into a Topic object. Now send.
	 * 13.Arrays.asList which is not mutable, whait id o is, new ArrayList<>(Arrays.asList(here are the objects));
	 * 14.If i add Arrays.asList i cannot add anything and i cannot move anything so i added ArrayList so it is now mutable List.
	 * 15.So, we pass the json as request body, and a Spring MVC was smart enough to convert it into an actual instance,
	 * and pass it to the business service. 
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	// 4.'PUT' to update the resource:-
	/*
	 *1.I have a updateTopic service the controller has actually believe it or not its done.
	 *2.we get the id from @PathVariable String id, and you get the 'topic' from the post body 
	 *and updates it by passing that to the updateTopic method.  
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	// 5.'DELETE' to delete the resource:-
	/*
	 *1.The thing to know that the method name in the controller really doesnt matter.
	 *2.I can give any arbitary name overhere. These names really dont matter.
	 *3.Is that just you have a method, and you have a right annotation on that method, and the right input arguments
	 *and storing the right things thats what the matters the nameitself. 
	 *  
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}// class
