package jp.ac.tama.repository;
import org.springframework.data.mirage.repository.MirageRepository;
import jp.ac.tama.entity.UserEntity;


public interface UserRepository extends MirageRepository<UserEntity, String> {
}