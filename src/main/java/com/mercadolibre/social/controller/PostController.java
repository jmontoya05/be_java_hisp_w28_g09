package com.mercadolibre.social.controller;

import com.mercadolibre.social.dto.request.PostRequestDto;
import com.mercadolibre.social.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {

    private final IPostService postService;

    public PostController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("products/post")
    public ResponseEntity<?> createPost(@RequestBody PostRequestDto postRequestDTO) {
        try {
            return new ResponseEntity<>(postService.createPost(postRequestDTO), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request: " + e.getMessage());
        }
    }

    // 11. Obtener la cantidad de productos en promoción de un determinado vendedor ?user_id={userId}
    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getCountPromoPost(@RequestParam("user_id") int userId){
        return new ResponseEntity<>(postService.getCountPromoPost(userId), HttpStatus.OK);
    }

}
