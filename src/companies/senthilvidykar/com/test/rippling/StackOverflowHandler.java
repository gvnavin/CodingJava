package companies.senthilvidykar.com.test.rippling;

import com.test.rippling.api.ApiResponse;
import com.test.rippling.api.ListingResponse;
import com.test.rippling.exceptions.ApiException;
import com.test.rippling.exceptions.ValidationException;
import com.test.rippling.models.Question;
import com.test.rippling.models.User;
import com.test.rippling.validation.Validator;

import java.util.*;

public class StackOverflowHandler {

    public static StackOverflowHandler handler;

    List<Question> questionList;
    Map<String, User> userData;

    public StackOverflowHandler() {
        this.questionList = new ArrayList<>();
        this.userData = new HashMap<>();
        this.userData.put("user1", new User("user1", "User Name 1"));
        this.userData.put("user2", new User("user2", "User Name 2"));
        this.userData.put("user3", new User("user3", "User Name 3"));
    }

    public static StackOverflowHandler getInstance() {
        if(handler == null) {
            handler = new StackOverflowHandler();
        }
        return handler;
    }

    private void validateQuestion(Question question) throws ValidationException{
        Validator.isNotEmpty("question.title", question.title);
        Validator.isNotEmpty("question.content", question.content);
        if(!userData.containsKey(question.user.userId)) {
            // Could be handled as AuthorizationException
            throw new ValidationException("question.user");
        }
    }

    public ApiResponse createQuestion(Question input) throws ApiException {
        try {
            validateQuestion(input);
            Question question = new Question(input.title, input.content, input.user);
            question.questionId = UUID.randomUUID().toString();
            questionList.add(question);
            return new ApiResponse("Success. New Question Id : " + question.questionId, 200);
        } catch (ValidationException e) {
            return new ApiResponse("Invalid Input : "+e.field, 400);
        } catch (Exception e) {
            return new ApiResponse("Internal Server error ", 500);
        }
    }

    public ApiResponse listQuestions() {
        try {
            return new ListingResponse<>(questionList);
        } catch (ValidationException e) {
            return new ApiResponse("Invalid Input : "+e.field, 400);
        } catch (Exception e) {
            return new ApiResponse("Internal Server error ", 500);
        }
    }
}
