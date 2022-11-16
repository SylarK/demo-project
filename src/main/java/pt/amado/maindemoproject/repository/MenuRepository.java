package pt.amado.maindemoproject.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import pt.amado.maindemoproject.entity.Menu;

import java.util.List;

@Repository
public class MenuRepository {

    public static final String HASH_KEY_NAME = "MENU-ITEM";

    @Autowired
    private RedisTemplate redisTemplate;

    public Menu save(Menu menu){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        menu.setId(Math.toIntExact(valueOperations.increment("sequence", 1l)));
        redisTemplate.opsForHash().put(HASH_KEY_NAME, menu.getId(), menu);
        return menu;
    }

    public List<Menu> findAll(){
        return redisTemplate.opsForHash().values(HASH_KEY_NAME);
    }

    public Menu findItemById(int id){
        return (Menu) redisTemplate.opsForHash().get(HASH_KEY_NAME, id);
    }

    public long deleteMenu(int id){
        return redisTemplate.opsForHash().delete(HASH_KEY_NAME, id);
    }

    public boolean deleteAllMenus(){
        return redisTemplate.delete(HASH_KEY_NAME);
    }
}
