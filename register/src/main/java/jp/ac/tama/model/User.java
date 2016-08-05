package jp.ac.tama.model;


/**
 * Created by owner on 2016/08/03.
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String password;
    private String prefecture_id;
    private String token;

}