package pt.amado.maindemoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.amado.maindemoproject.dto.MenuDTO;
import pt.amado.maindemoproject.entity.Menu;
import pt.amado.maindemoproject.exception.MenuException;
import pt.amado.maindemoproject.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    @PostMapping
    public ResponseEntity<MenuDTO> save(@RequestBody MenuDTO menuDetails) {
        return ResponseEntity.ok(menuService.save(menuDetails));
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getMenus() {
        return ResponseEntity.ok(menuService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> findMenuItemById(@PathVariable int id) throws MenuException {
        return ResponseEntity.ok(menuService.findItemById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMenuById(@PathVariable int id) throws MenuException {
        return ResponseEntity.ok(menuService.deleteMenu(id));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAllMenus() {
        return ResponseEntity.ok(menuService.deleteAllMenus());
    }

}