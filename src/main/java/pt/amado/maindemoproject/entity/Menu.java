package pt.amado.maindemoproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Menu")
public class Menu implements Serializable {
    @Id
    private int id;

    //Used to speed up the property based search
    //@Index
    //private int redisExtId;

    private String item;
    private long price;
}
