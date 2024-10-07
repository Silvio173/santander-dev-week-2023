package santader_dev_week.sevice;

import org.springframework.stereotype.Service;
import santader_dev_week.model.User;
import santader_dev_week.repository.UserRepository;

import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())){
            throw new IllegalArgumentException("This user id already exist");
        }
        return userRepository.save(userToCreate);
    }
}
