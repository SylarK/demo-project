package pt.amado.maindemoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pt.amado.maindemoproject.entity.Menu;
import pt.amado.maindemoproject.repository.MenuRepository;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @PostMapping
    public Menu save(@RequestBody Menu menuDetails){
        return menuRepository.save(menuDetails);
    }

    @GetMapping
    public List<Menu> getMenus(){
        return menuRepository.findAll();
    }

    @GetMapping("/{id}")
    public Menu findMenuItemById(@PathVariable int id){
        return menuRepository.findItemById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteMenuById(@PathVariable int id){
        return menuRepository.deleteMenu(id);
    }

}
