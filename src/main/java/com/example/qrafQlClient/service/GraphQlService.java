package com.example.qrafQlClient.service;

import com.example.qrafQlClient.model.DeletedWord;
import com.example.qrafQlClient.model.Word;
import com.example.qrafQlClient.model.WordWithTest;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class GraphQlService {

    private final HttpGraphQlClient qlClient;

    public GraphQlService() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8080/v1/graphql")
                .build();
        qlClient = HttpGraphQlClient.builder(client).build();
    }

    public List<Word> getWords() {
        String document = """
                query {
                  words {
                    id
                    english
                    russian
                    word_type
                    user_id
                    test_id
                  }
                }
                """;
        Mono<List<Word>> listMono = qlClient.document(document)
                .retrieve("words")
                .toEntityList(Word.class);

        return listMono.block();
    }

    public List<Word> getWordsNotFullFields() {
        String document = """
                query {
                  words {
                    id
                    english
                    russian
                  }
                }
                """;
        Mono<List<Word>> listMono = qlClient.document(document)
                .retrieve("words")
                .toEntityList(Word.class);

        return listMono.block();
    }


    public Word getWordsById(Long id) {
        String document = """
                query {
                  words_by_pk(id: %d) {
                    id
                    english
                    russian
                    word_type
                    test_id
                    user_id
                  }
                }
                """.formatted(id);
        Mono<Word> mono = qlClient.document(document)
                .retrieve("words_by_pk")
                .toEntity(Word.class);

        return mono.block();
    }

    public Word addWord(Word word) {
        String document = """
                mutation MyMutation {
                    insert_words_one(object: {
                        english: "%s",
                        russian: "%s",
                        word_type: "%s",
                        test_id: %d,
                        user_id: %d
                    }) {
                      id
                      english
                      russian
                      word_type
                      test_id
                      user_id
                    }
                  }
                """.formatted(word.getEnglish(),
                word.getRussian(),
                word.getWordType(),
                word.getTestId(),
                word.getUserId());
        Word wordResponse = qlClient.document(document).execute().block().field("insert_words_one").toEntity(Word.class);

        return wordResponse;
    }

    public Word updateWord(Long id, Word word) {
        String document = """
                mutation {
                        update_words_by_pk(pk_columns: {id: %d}, _set: {english: "%s", russian: "%s"}) {
                          id
                          english
                          russian
                          word_type
                          test_id
                          user_id
                        }
                      }
                """.formatted(id, word.getEnglish(), word.getRussian());
        Word wordResponse = qlClient.document(document).execute().block().field("update_words_by_pk").toEntity(Word.class);

        return wordResponse;
    }

    public Long deleteWordById(Long id) {

        String document = """
                mutation MyMutation {
                      delete_words_by_pk(id: %d) {
                        id
                      }
                    }
                """.formatted(id);
        DeletedWord response = qlClient.document(document).execute().block().field("delete_words_by_pk").toEntity(DeletedWord.class);

        return response.getId();
    }

    public List<WordWithTest> getWordsWithTest() {
        String document = """
                query {
                     words {
                       id
                       english
                       russian
                       word_type
                       user_id
                       test {
                         id
                         name
                         description
                       }
                     }
                   }
                """;
        Mono<List<WordWithTest>> listMono = qlClient.document(document)
                .retrieve("words")
                .toEntityList(WordWithTest.class);

        return listMono.block();
    }
}
