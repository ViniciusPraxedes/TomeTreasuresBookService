package com.example.bookservice.controller;

import com.example.bookservice.model.Book;
import com.example.bookservice.model.BookRequest;
import com.example.bookservice.model.Category;
import com.example.bookservice.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "Create a new book")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @PostMapping("/create")
    public Book createBook(@Valid @RequestBody BookRequest request) {
        return bookService.createBook(request);
    }

    @Operation(summary = "Get all books")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @GetMapping("/all")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @Operation(summary = "Get book by item code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @GetMapping("/{itemCode}")
    public Book getBookByItemCode(@PathVariable String itemCode){
        return bookService.getBookByItemCode(itemCode);
    }

    @Operation(summary = "Update book by item code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @PutMapping("/{itemCode}")
    public Book changeBookByItemCode(@PathVariable String itemCode, @RequestBody BookRequest request){
        return bookService.changeBookByItemCode(itemCode, request);
    }

    @Operation(summary = "Delete book by item code")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @DeleteMapping("/{itemCode}")
    public void deleteBookByItemCode(@PathVariable String itemCode){
        bookService.deleteBookByItemCode(itemCode);
    }

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Category.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @GetMapping("/all/categories")
    public List<Category> getAllCategories(){
        return bookService.getAllCategories();
    }

    @Operation(summary = "Get books by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Book.class))),
            @ApiResponse(responseCode = "400", description = "Bad request, one or more parameters in the request is bad formatted", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authorization required", content = @Content),
            @ApiResponse(responseCode = "403", description = "Accessing the resource you were trying to reach is forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "The resource you were trying to reach is not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "The code is broken", content = @Content)})
    @GetMapping("/books/{categories}")
    public List<Book> getAllCategories(@PathVariable Set<Category> categories){
        return bookService.getBooksByCategory(categories);
    }

}
