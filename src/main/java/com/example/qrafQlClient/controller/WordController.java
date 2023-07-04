package com.example.qrafQlClient.controller;

import com.example.qrafQlClient.model.Word;
import com.example.qrafQlClient.model.WordWithTest;
import com.example.qrafQlClient.service.GraphQlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/word")
@RestController
public class WordController {


    private final GraphQlService graphQlService;

    @Autowired
    public WordController(GraphQlService graphQlService) {
        this.graphQlService = graphQlService;
    }

    @GetMapping()
    public List<Word> getAllWords() {
        return graphQlService.getWords();
    }

    @GetMapping("not-full")
    public List<Word> getWordsNotFullFields() {
        return graphQlService.getWordsNotFullFields();
    }

    @GetMapping("/{id}")
    public Word getWordsById(@PathVariable Long id) {
        return graphQlService.getWordsById(id);
    }

    @PostMapping()
    public Word addWord(@RequestBody Word word) {
        return graphQlService.addWord(word);
    }

    @PutMapping("/{id}")
    public Word getAllWords(@PathVariable Long id, @RequestBody Word word) {
        return graphQlService.updateWord(id, word);
    }

    @DeleteMapping("/{id}")
    public Long getAllWords(@PathVariable Long id) {
        return graphQlService.deleteWordById(id);
    }

    @GetMapping("/with-test")
    public List<WordWithTest> getAllWordsWithTest() {
        return graphQlService.getWordsWithTest();
    }
}
