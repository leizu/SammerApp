package jp.ac.tama.entity;

/**
 * Created by owner on 2016/08/04.
 */
import org.springframework.data.annotation.Id;

import jp.sf.amateras.mirage.annotation.Column;
import jp.sf.amateras.mirage.annotation.PrimaryKey;
import jp.sf.amateras.mirage.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@Table(name = "user")
@AllArgsConstructor
public class UserEntity {
    @Column(name = "user_name")
    @Id
    @PrimaryKey(generationType = PrimaryKey.GenerationType.APPLICATION)
    private String user_name;

    @Column(name = "password")
    private String password;

    @Column(name = "prefucture_id")
    private String prefecture_id;

    @Column(name = "token")
    private String token;

}