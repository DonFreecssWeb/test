package com.example.testerrorendpoint.currency;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CurrencyController {

    @Autowired
    CurrencyServiceImpl currencyService ;
    @GetMapping("")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok().body("Funciona");
    }

    @GetMapping("/tipo-cambio/token")
    public ResponseEntity<String> generateToken(
            @RequestParam(name = "from",defaultValue = "") String from,
            @RequestParam(name = "to",defaultValue = "") String to
    ){
        try {
            if (from == null || from.isBlank()) {
                return ResponseEntity.badRequest().body("El campo 'moneda origen' no puede ser vacío");
            }else  if (to == null || to.isBlank()) {
                return ResponseEntity.badRequest().body("El campo 'moneda destino' no puede ser vacío");
            } else {
                return ResponseEntity.ok().body(currencyService.generateToken(from, to));
            }
        }catch (Exception e){
            return ResponseEntity.ok().body(e.getMessage());
        }
    }

}
