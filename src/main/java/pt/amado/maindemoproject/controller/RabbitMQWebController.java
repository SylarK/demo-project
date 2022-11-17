package pt.amado.maindemoproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pt.amado.maindemoproject.entity.Employee;
import pt.amado.maindemoproject.service.rabbit.RabbitSenderService;

@RestController
@RequestMapping("/api/rabbit/")
public class RabbitMQWebController {

    RabbitSenderService rabbitSenderService;

    @Autowired
    RabbitMQWebController(RabbitSenderService rabbitSenderService){
        this.rabbitSenderService = rabbitSenderService;
    }

    @GetMapping(value = "producer")
    public String producer(@RequestParam("name") String name,
                           @RequestParam("id") String id){

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        rabbitSenderService.send(employee);
        return "Message sent to the RabbitMQ demo-project";
    }
}
