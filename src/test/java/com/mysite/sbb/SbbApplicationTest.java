package com.mysite.sbb;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SbbApplicationTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Transactional
    @Test
    void testJPa() {
        Question q1 = new Question();
        q1.setSubject("질문1 제목");
        q1.setContent("질문1 내용");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("질문2 제목");
        q2.setContent("질문2 내용");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);

        List<Question> questions = this.questionRepository.findAll();
        assertEquals(2, questions.size());

        Question question = questions.get(0);
        assertEquals("질문1 제목", question.getSubject());
    }
}
