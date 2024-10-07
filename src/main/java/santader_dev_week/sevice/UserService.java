package santader_dev_week.sevice;

import santader_dev_week.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
