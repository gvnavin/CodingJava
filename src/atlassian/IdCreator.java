package atlassian;

public class IdCreator {

    String getId(Request request) {
        //extended based on our requirement
        return request.customerId;
    }

}
