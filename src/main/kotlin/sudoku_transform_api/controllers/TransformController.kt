package sudoku_transform_api.controllers

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class TransformController {

    @PostMapping("/transform/turn/left")
    fun turnLeft(@RequestBody sudoku : Sudoku) {

    }
}