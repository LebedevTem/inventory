package mmtr.inventory.service;

import lombok.RequiredArgsConstructor;
import mmtr.inventory.model.exception.ForbiddenException;
import mmtr.inventory.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  // TODO добавить авторизацию, смотреть из контекста
  public boolean isCurrentUserAdmin() {
    return true;
  }

  public void throwForbiddenIfNotAdmin() {
    if (!isCurrentUserAdmin()) {
      throw new ForbiddenException();
    }
  }

  // TODO добавить методы создания, получения, обновления пользователей
}
